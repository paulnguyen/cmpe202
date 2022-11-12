/*
	Gumball API in Go (Version 4)
	Uses MySQL
*/

package main

import (
	"fmt"
	"log"
	"net/http"
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
*/

//var mysql_connect = "root:cmpe281@tcp(127.0.0.1:3306)/cmpe281"
//var mysql_connect = "root:cmpe281@tcp(mysql-service:3306)/cmpe281"
var mysql_connect = "admin:cmpe281@tcp(10.69.64.3:3306)/cmpe281"

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

// Init MySQL DB Connection

func init() {

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
			log.Println(id, count, model, serial)
		}
		err = rows.Err()
		if err != nil {
			log.Fatal(err)
		}
	}
	defer db.Close()

}


// API Routes
func initRoutes(mx *mux.Router, formatter *render.Render) {
	mx.HandleFunc("/ping", pingHandler(formatter)).Methods("GET")
	mx.HandleFunc("/gumball", gumballHandler(formatter)).Methods("GET")
	mx.HandleFunc("/gumball", gumballUpdateHandler(formatter)).Methods("PUT")
	mx.HandleFunc("/order", gumballNewOrderHandler(formatter)).Methods("POST")
	mx.HandleFunc("/order/{id}", gumballOrderStatusHandler(formatter)).Methods("GET")
	mx.HandleFunc("/order", gumballOrderStatusHandler(formatter)).Methods("GET")
	mx.HandleFunc("/orders", gumballProcessOrdersHandler(formatter)).Methods("POST")
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
    	var ord = order {
					Id: uuid.String(),            		
					OrderStatus: "Order Placed",
		}
		if orders == nil {
			orders = make(map[string]order)
		}
		orders[uuid.String()] = ord
		fmt.Println( "Orders: ", orders )
		formatter.JSON(w, http.StatusOK, ord)
	}
}

// API Get Order Status
func gumballOrderStatusHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
		params := mux.Vars(req)
		var uuid string = params["id"]
		fmt.Println( "Order ID: ", uuid )
		if uuid == ""  {
			fmt.Println( "Orders:", orders )
			var orders_array [] order
			for key, value := range orders {
    			fmt.Println("Key:", key, "Value:", value)
    			orders_array = append(orders_array, value)
			}
			formatter.JSON(w, http.StatusOK, orders_array)
		} else {
			var ord = orders[uuid]
			fmt.Println( "Order: ", ord )
			formatter.JSON(w, http.StatusOK, ord)
		}
	}
}

// API Process Orders 
func gumballProcessOrdersHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
		for key, value := range orders {
    			fmt.Println("Key:", key, "Value:", value)
    			var ord = orders[key] 
    			ord.OrderStatus = "Order Processed"
    			orders[key] = ord
			}
		fmt.Println( "Orders: ", orders )
		formatter.JSON(w, http.StatusOK, "Orders Processed!")
	}
}



/*

	-- Create Database Schema (DB User: root, DB Pass: cmpe281)

		Database Schema: cmpe281

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


*/

  


