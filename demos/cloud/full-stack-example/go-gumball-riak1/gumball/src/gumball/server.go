/*
	Gumball API in Go
	Uses MySQL & Riak KV
*/

package main

import (
	"fmt"
	"log"
	"net/http"
	"io/ioutil"
	"time"
	"os"
	"strings"
	"encoding/json"
	"github.com/codegangsta/negroni"
	"github.com/gorilla/mux"
	"github.com/unrolled/render"
	"github.com/satori/go.uuid"
    "database/sql"
	_ "github.com/go-sql-driver/mysql"
)

/*
	Go's SQL Package:  
		Tutorial: http://go-database-sql.org/index.html
		Reference: https://golang.org/pkg/database/sql/

		var mysql_connect = "root:cmpe281@tcp(127.0.0.1:3306)/cmpe281"
		var mysql_connect = "root:cmpe281@tcp(mysql:3306)/cmpe281"

	Go Rest Client:
		Tutorial:	https://medium.com/@marcus.olsson/writing-a-go-client-for-your-restful-api-c193a2f4998c
		Reference:	https://golang.org/pkg/net/http/

		var server1 = "http://localhost:7000"
		var server2 = "http://localhost:7001"
		var server3 = "http://localhost:7002"
		var server1 = "http://gumball_member_1:8098"
		var server2 = "http://gumball_member_2:8098"
		var server3 = "http://gumball_member_3:8098"

	Go Get Environment Settings:

		mysql_connect = os.Getenv("MYSQL")
		server1 = os.Getenv("RIAK1")
		server2 = os.Getenv("RIAK2")
		server3 = os.Getenv("RIAK3")

	Set Localhost Environment:
	
		export MYSQL="root:cmpe281@tcp(127.0.0.1:3306)/cmpe281"
		export RIAK1="http://localhost:7000"
		export RIAK2="http://localhost:7001"
		export RIAK3="http://localhost:7002"

*/

/* MySQL */
var mysql_connect = "" // set in environment

/* Riak REST Client */
var debug = true
var server1 = "" // set in environment
var server2 = "" // set in environment
var server3 = "" // set in environment

type Client struct {
	Endpoint string
	*http.Client
}

var tr = &http.Transport{
	MaxIdleConns:       10,
	IdleConnTimeout:    30 * time.Second,
	DisableCompression: true,
}

func NewClient(server string) *Client {
	return &Client{
		Endpoint:  	server,
		Client: 	&http.Client{Transport: tr},
	}
}

func (c *Client) Ping() (string, error) {
	resp, err := c.Get(c.Endpoint + "/ping" )
	if err != nil {
		fmt.Println("[RIAK DEBUG] " + err.Error())
		return "Ping Error!", err
	}
	defer resp.Body.Close()
	body, err := ioutil.ReadAll(resp.Body)
	if debug { fmt.Println("[RIAK DEBUG] GET: " + c.Endpoint + "/ping => " + string(body)) }
	return string(body), nil
}

func (c *Client) CreateOrder(key, value string) (order, error) {
   	var ord_nil = order {}
	reqbody := "{\"Id\": \"" + 
		key + 
		"\",\"OrderStatus\": \"" +
		 value + 
		 "\"}"
	resp, err := c.Post(c.Endpoint + "/buckets/orders/keys/"+key+"?returnbody=true", 
						"application/json", strings.NewReader(reqbody) )
	if err != nil {
		fmt.Println("[RIAK DEBUG] " + err.Error())
		return ord_nil, err
	}
	defer resp.Body.Close()
	body, err := ioutil.ReadAll(resp.Body)
	if debug { fmt.Println("[RIAK DEBUG] POST: " + c.Endpoint + "/buckets/orders/keys/"+key+"?returnbody=true => " + string(body)) }
	var ord = order {
		Id: key,            		
		OrderStatus: value,
	}
	return ord, nil
}

func (c *Client) GetOrder(key string) (order, error) {
	var ord_nil = order {}
	resp, err := c.Get(c.Endpoint + "/buckets/orders/keys/"+key )
	if err != nil {
		fmt.Println("[RIAK DEBUG] " + err.Error())
		return ord_nil, err
	}
	defer resp.Body.Close()
	body, err := ioutil.ReadAll(resp.Body)
	if debug { fmt.Println("[RIAK DEBUG] GET: " + c.Endpoint + "/buckets/orders/keys/"+key +" => " + string(body)) }
	var ord = order { }
	if err := json.Unmarshal(body, &ord); err != nil {
		fmt.Println("RIAK DEBUG] JSON unmarshaling failed: %s", err)
		return ord_nil, err
	}
	return ord, nil
}

func (c *Client) UpdateOrder(key, value string) (order, error) {
	var ord_nil = order {}
	reqbody := "{\"Id\": \"" + 
		key + 
		"\",\"OrderStatus\": \"" +
		 value + 
		 "\"}"
	req, _  := http.NewRequest("PUT", c.Endpoint + "/buckets/orders/keys/"+key+"?returnbody=true", strings.NewReader(reqbody) )
	req.Header.Add("Content-Type", "application/json")
	//fmt.Println( req )
	resp, err := c.Do(req)	
	if err != nil {
		fmt.Println("[RIAK DEBUG] " + err.Error())
		return ord_nil, err
	}	
	defer resp.Body.Close()
	body, err := ioutil.ReadAll(resp.Body)
	if debug { fmt.Println("[RIAK DEBUG] PUT: " + c.Endpoint + "/buckets/orders/keys/"+key+"?returnbody=true => " + string(body)) }
	var ord = order { }
	if err := json.Unmarshal(body, &ord); err != nil {
		fmt.Println("RIAK DEBUG] JSON unmarshaling failed: %s", err)
		return ord_nil, err
	}
	return ord, nil
}


// NewServer configures and returns a Server.
func NewServer() *negroni.Negroni {
	formatter := render.New(render.Options{
		IndentJSON: true,
	})
	n := negroni.Classic()
	mx := mux.NewRouter()
	initRoutes(mx, formatter)
	n.UseHandler(mx)
	return n
}

// Init Database Connections

func init() {

	// Get Environment Config
	mysql_connect = os.Getenv("MYSQL")
	server1 = os.Getenv("RIAK1")
	server2 = os.Getenv("RIAK2")
	server3 = os.Getenv("RIAK3")

	fmt.Println("MySQL Connect:", mysql_connect )	
	fmt.Println("Riak  Server1:", server1 )	
	fmt.Println("Riak  Server2:", server2 )	
	fmt.Println("Riak  Server3:", server3 )	

	// MySQL Setup	
	db, err := sql.Open("mysql", mysql_connect)
	if err != nil {
		log.Fatal(err)
	} else {
		var (
			id int
			count int
			model string
			serial string
		)
		rows, err := db.Query("select id, count_gumballs, model_number, serial_number from gumball where id = ?", 1)
		if err != nil {
			log.Fatal(err)
		}
		defer rows.Close()
		for rows.Next() {
			err := rows.Scan(&id, &count, &model, &serial)
			if err != nil {
				log.Fatal(err)
			}
			log.Println("MySQL Ping: ", id, count, model, serial)
		}
		err = rows.Err()
		if err != nil {
			log.Fatal(err)
		}
	}
	defer db.Close()

	// Riak KV Setup	
	c1 := NewClient(server1)
	msg, err := c1.Ping( )
	if err != nil {
		log.Fatal(err)
	} else {
		log.Println("Riak Ping Server1: ", msg)		
	}

	c2 := NewClient(server2)
	msg, err = c2.Ping( )
	if err != nil {
		log.Fatal(err)
	} else {
		log.Println("Riak Ping Server2: ", msg)		
	}

	c3 := NewClient(server3)
	msg, err = c3.Ping( )
	if err != nil {
		log.Fatal(err)
	} else {
		log.Println("Riak Ping Server3: ", msg)		
	}

}


// API Routes
func initRoutes(mx *mux.Router, formatter *render.Render) {
	mx.HandleFunc("/ping", pingHandler(formatter)).Methods("GET")
	mx.HandleFunc("/gumball", gumballHandler(formatter)).Methods("GET")
	mx.HandleFunc("/gumball", gumballUpdateHandler(formatter)).Methods("PUT")
	mx.HandleFunc("/order", gumballNewOrderHandler(formatter)).Methods("POST")
	mx.HandleFunc("/order/{id}", gumballOrderStatusHandlerAny(formatter)).Methods("GET")
	mx.HandleFunc("/order/{id}", gumballProcessOrdersHandler(formatter)).Methods("POST")
}

// Helper Functions
func failOnError(err error, msg string) {
	if err != nil {
		log.Fatalf("%s: %s", msg, err)
		panic(fmt.Sprintf("%s: %s", msg, err))
	}
}

// API Ping Handler
func pingHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
		formatter.JSON(w, http.StatusOK, struct{ Test string }{"API version 1.0 alive!"})
	}
}

// API Gumball Machine Handler
func gumballHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {

		var (
			id int
			count int
			model string
			serial string
		)
		db, err := sql.Open("mysql", mysql_connect)
		defer db.Close()
		if err != nil {
			log.Fatal(err)
		} else {
			rows, _ := db.Query("select id, count_gumballs, model_number, serial_number from gumball where id = ?", 1)
			defer rows.Close()
			for rows.Next() {
				rows.Scan(&id, &count, &model, &serial)
				log.Println(id, count, model, serial)
			}
		}
		result := gumballMachine {
			Id : id,
			CountGumballs : count,
			ModelNumber : model,
			SerialNumber : serial,
		}

        fmt.Println("Gumball Machine:", result )
		formatter.JSON(w, http.StatusOK, result)
	}
}

// API Update Gumball Inventory
func gumballUpdateHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
    	var m gumballMachine
    	_ = json.NewDecoder(req.Body).Decode(&m)		
    	fmt.Println("Update Gumball Inventory To: ", m.CountGumballs)
	
		var (
			id int
			count int
			model string
			serial string
		)
		db, err := sql.Open("mysql", mysql_connect)
		defer db.Close()
		stmt, err := db.Prepare("update gumball set count_gumballs = ? where id = ?")
		if err != nil {
			log.Fatal(err)
		}
		_, err = stmt.Exec( m.CountGumballs, 1)
		if err != nil {
			log.Fatal(err)
		}

		if err != nil {
			log.Fatal(err)
		} else {
			rows, _ := db.Query("select id, count_gumballs, model_number, serial_number from gumball where id = ?", 1)
			defer rows.Close()
			for rows.Next() {
				rows.Scan(&id, &count, &model, &serial)
				log.Println(id, count, model, serial)
			}
		}
		result := gumballMachine {
			Id : id,
			CountGumballs : count,
			ModelNumber : model,
			SerialNumber : serial,
		}

        fmt.Println("Gumball Machine:", result )
		formatter.JSON(w, http.StatusOK, result)
	}
}

// API Create New Gumball Order
func gumballNewOrderHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {

		uuid, _ := uuid.NewV4()
		value := "Order Placed"

		c1 := NewClient(server1)
		ord, err := c1.CreateOrder(uuid.String(), value)
		if err != nil {
			log.Fatal(err)
			formatter.JSON(w, http.StatusBadRequest, err)
		} else {
			formatter.JSON(w, http.StatusOK, ord)
		}
	}
}

// API Get Order Status
func gumballOrderStatusHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
		
		params := mux.Vars(req)
		var uuid string = params["id"]
		fmt.Println( "Order Params ID: ", uuid )

		if uuid == ""  {
			formatter.JSON(w, http.StatusBadRequest, "Invalid Request. Order ID Missing.")
		} else {
			ord := getOrder(server1, uuid)
			if ord == (order{}) {
				formatter.JSON(w, http.StatusBadRequest, "")
			} else {
				fmt.Println( "Order: ", ord )
				formatter.JSON(w, http.StatusOK, ord)
			}
		}
	}
}

func getOrder(server, uuid string) order {
	var ord_nil = order {}
	c := NewClient(server)
	ord, err := c.GetOrder(uuid)
	if err != nil {
		log.Fatal(err)
		return ord_nil
	} else {
		return ord
	}
}


// API Get Order Status - Concurrent - Get One
func gumballOrderStatusHandlerAny(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
		
		params := mux.Vars(req)
		var uuid string = params["id"]
		fmt.Println( "Order Params ID: ", uuid )

		c1 := make(chan order)
    	c2 := make(chan order)
    	c3 := make(chan order)

		if uuid == ""  {
			formatter.JSON(w, http.StatusBadRequest, "Invalid Request. Order ID Missing.")
		} else {

			go getOrderServer1(uuid, c1) 
			go getOrderServer2(uuid, c2) 
			go getOrderServer3(uuid, c3) 

			var ord order
		  	select {
			    case ord = <-c1:
			        fmt.Println("Received Server1: ", ord)
			    case ord = <-c2:
			        fmt.Println("Received Server2: ", ord)
			    case ord = <-c3:
			        fmt.Println("Received Server3: ", ord)
		    }

			if ord == (order{}) {
				formatter.JSON(w, http.StatusBadRequest, "")
			} else {
				fmt.Println( "Order: ", ord )
				formatter.JSON(w, http.StatusOK, ord)
			}
		}
	}
}

func getOrderServer1(uuid string, chn chan<- order) {
	var ord_nil = order {}
	c := NewClient(server1)
	ord, err := c.GetOrder(uuid)
	if err != nil {
		chn <- ord_nil
	} else {
		fmt.Println( "Server1: ", ord)
		chn <- ord
	}
}

func getOrderServer2(uuid string, chn chan<- order) {
	var ord_nil = order {}
	c := NewClient(server2)
	ord, err := c.GetOrder(uuid)
	if err != nil {
		chn <- ord_nil
	} else {
		fmt.Println( "Server2: ", ord)
		chn <- ord
	}
}

func getOrderServer3(uuid string, chn chan<- order) {
	var ord_nil = order {}
	c := NewClient(server3)
	ord, err := c.GetOrder(uuid)
	if err != nil {
		chn <- ord_nil
	} else {
		fmt.Println( "Server3: ", ord)
		chn <- ord
	}
}


// API Process Order
func gumballProcessOrdersHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {

		params := mux.Vars(req)
		var uuid string = params["id"]
		fmt.Println( "Order Params ID: ", uuid )
		value := "Order Processed"

		if uuid == ""  {
			formatter.JSON(w, http.StatusBadRequest, "Invalid Request. Order ID Missing.")
		} else {
			c1 := NewClient(server1)
			ord, err := c1.UpdateOrder(uuid, value)
			if err != nil {
				log.Fatal(err)
				formatter.JSON(w, http.StatusBadRequest, err)
			} else {
				formatter.JSON(w, http.StatusOK, ord)
			}
		}
	}
}



/*

-- Setup Riak Bucket

riak ping
riak-admin test
riak-admin bucket-type create gumball '{"props":{"search_index":"orders"}}'
riak-admin bucket-type activate gumball

-- Create Database Schema (DB User: root, DB Pass: cmpe281)

create database cmpe281 ;
use cmpe281 ;

-- Create Database Table 

CREATE TABLE gumball (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  version bigint(20) NOT NULL,
  count_gumballs int(11) NOT NULL,
  model_number varchar(255) NOT NULL,
  serial_number varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY serial_number (serial_number)
) ;

-- Load Data

insert into gumball ( id, version, count_gumballs, model_number, serial_number ) 
values ( 1, 0, 1000, 'M102988', '1234998871109' ) ;

-- Verify Data 

select * from gumball ;

-- Grant Remote Access for Admin (Optional)

apt-get update
apt-get install mysql-client
mysql -u root -p -h gumball_mysql_1 

CREATE USER 'admin' IDENTIFIED BY 'cmpe281';

GRANT ALL PRIVILEGES
ON *.*
TO 'admin'@'%'
IDENTIFIED BY 'cmpe281';



*/

  


