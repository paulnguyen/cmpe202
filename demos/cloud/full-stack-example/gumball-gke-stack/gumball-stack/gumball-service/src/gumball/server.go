/*
	Gumball API in Go (Version 2)
	Uses MongoDB and RabbitMQ 

	http://labix.org/mgo
	https://github.com/streadway/amqp

*/

package main

import (
	"fmt"
	"log"
	"net/http"
	"encoding/json"
	"github.com/codegangsta/negroni"
	"github.com/streadway/amqp"
	"github.com/gorilla/mux"
	"github.com/unrolled/render"
	"github.com/satori/go.uuid"
	"gopkg.in/mgo.v2"
    "gopkg.in/mgo.v2/bson"
)

var config = "GKE" // LOCAL, K8S, GKE

// MongoDB Config (Local Docker)
var mongodb_server = ""
var mongodb_database = ""
var mongodb_collection = ""

// RabbitMQ Config (Local Docker)
var rabbitmq_server = ""
var rabbitmq_port = ""
var rabbitmq_queue = ""
var rabbitmq_user = ""
var rabbitmq_pass = ""

func init() {
    switch config {
    case "LOCAL":
    	mongodb_server = "mongodb://admin:cmpe281@localhost:27017/cmpe281"
		mongodb_database = "cmpe281"
		mongodb_collection = "gumball"
		rabbitmq_server = "localhost"
		rabbitmq_port = "5672"
		rabbitmq_queue = "gumball"
		rabbitmq_user = "guest"
		rabbitmq_pass = "guest"
    case "K8S":
    	mongodb_server = "mongodb://admin:cmpe281@mongo-service:27017/cmpe281"
		mongodb_database = "cmpe281"
		mongodb_collection = "gumball"
		rabbitmq_server = "rabbitmq-service"
		rabbitmq_port = "5672"
		rabbitmq_queue = "gumball"
		rabbitmq_user = "guest"
		rabbitmq_pass = "guest"
    case "GKE":
    	mongodb_server = "mongodb://admin:cmpe281@10.138.0.9:27017/cmpe281"
		mongodb_database = "cmpe281"
		mongodb_collection = "gumball"
		rabbitmq_server = "rabbitmq-rabbitmq-svc"
		rabbitmq_port = "5672"
		rabbitmq_queue = "gumball"
		rabbitmq_user = "rabbit"
		rabbitmq_pass = "ZracSMjs9k8b"
    }
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
		fmt.Println("mongodb_server:", mongodb_server )
		fmt.Println("mongodb_database:", mongodb_database )
		fmt.Println("mongodb_collection:", mongodb_collection )
		fmt.Println("rabbitmq_server:", rabbitmq_server )
		fmt.Println("rabbitmq_port:", rabbitmq_port )
		fmt.Println("rabbitmq_queue:", rabbitmq_queue )
		fmt.Println("rabbitmq_user:", rabbitmq_user )
		fmt.Println("rabbitmq_pass:", rabbitmq_pass )
		formatter.JSON(w, http.StatusOK, struct{ Test string }{"API version 1.0 alive!"})
	}
}

// API Gumball Machine Handler
func gumballHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
		session, err := mgo.Dial(mongodb_server)
        if err != nil {
                panic(err)
        }
        defer session.Close()
        session.SetMode(mgo.Monotonic, true)
        c := session.DB(mongodb_database).C(mongodb_collection)
        var result bson.M
        err = c.Find(bson.M{"SerialNumber" : "1234998871109"}).One(&result)
        if err != nil {
                log.Fatal(err)
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
		session, err := mgo.Dial(mongodb_server)
        if err != nil {
                panic(err)
        }
        defer session.Close()
        session.SetMode(mgo.Monotonic, true)
        c := session.DB(mongodb_database).C(mongodb_collection)
        query := bson.M{"SerialNumber" : "1234998871109"}
        change := bson.M{"$set": bson.M{ "CountGumballs" : m.CountGumballs}}
        err = c.Update(query, change)
        if err != nil {
                log.Fatal(err)
        }
       	var result bson.M
        err = c.Find(bson.M{"SerialNumber" : "1234998871109"}).One(&result)
        if err != nil {
                log.Fatal(err)
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
		queue_send(uuid.String())
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

		// Open MongoDB Session
		session, err := mgo.Dial(mongodb_server)
        if err != nil {
                panic(err)
        }
        defer session.Close()
        session.SetMode(mgo.Monotonic, true)
        c := session.DB(mongodb_database).C(mongodb_collection)

       	// Get Gumball Inventory 
        var result bson.M
        err = c.Find(bson.M{"SerialNumber" : "1234998871109"}).One(&result)
        if err != nil {
                log.Fatal(err)
        }

 		var count int = result["CountGumballs"].(int)
        fmt.Println("Current Inventory:", count )

		// Process Order IDs from Queue
		var order_ids []string = queue_receive()
		for i := 0; i < len(order_ids); i++ {
			var order_id = order_ids[i]
			fmt.Println("Order ID:", order_id)
			var ord = orders[order_id] 
			ord.OrderStatus = "Order Processed"
			orders[order_id] = ord
			count -= 1
		}
		fmt.Println( "Orders: ", orders , "New Inventory: ", count)

		// Update Gumball Inventory
		query := bson.M{"SerialNumber" : "1234998871109"}
        change := bson.M{"$set": bson.M{ "CountGumballs" : count}}
        err = c.Update(query, change)
        if err != nil {
                log.Fatal(err)
        }

		// Return Order Status
		formatter.JSON(w, http.StatusOK, orders)
	}
}

// Send Order to Queue for Processing
func queue_send(message string) {
	conn, err := amqp.Dial("amqp://"+rabbitmq_user+":"+rabbitmq_pass+"@"+rabbitmq_server+":"+rabbitmq_port+"/")
	failOnError(err, "Failed to connect to RabbitMQ")
	defer conn.Close()

	ch, err := conn.Channel()
	failOnError(err, "Failed to open a channel")
	defer ch.Close()

	q, err := ch.QueueDeclare(
		rabbitmq_queue, // name
		false,   // durable
		false,   // delete when unused
		false,   // exclusive
		false,   // no-wait
		nil,     // arguments
	)
	failOnError(err, "Failed to declare a queue")

	body := message
	err = ch.Publish(
		"",     // exchange
		q.Name, // routing key
		false,  // mandatory
		false,  // immediate
		amqp.Publishing{
			ContentType: "text/plain",
			Body:        []byte(body),
		})
	log.Printf(" [x] Sent %s", body)
	failOnError(err, "Failed to publish a message")
}

// Receive Order from Queue to Process
func queue_receive() []string {
	conn, err := amqp.Dial("amqp://"+rabbitmq_user+":"+rabbitmq_pass+"@"+rabbitmq_server+":"+rabbitmq_port+"/")
	failOnError(err, "Failed to connect to RabbitMQ")
	defer conn.Close()

	ch, err := conn.Channel()
	failOnError(err, "Failed to open a channel")
	defer ch.Close()

	q, err := ch.QueueDeclare(
		rabbitmq_queue, // name
		false,   // durable
		false,   // delete when usused
		false,   // exclusive
		false,   // no-wait
		nil,     // arguments
	)
	failOnError(err, "Failed to declare a queue")

	msgs, err := ch.Consume(
		q.Name, // queue
		"orders",     // consumer
		true,   // auto-ack
		false,  // exclusive
		false,  // no-local
		false,  // no-wait
		nil,    // args
	)
	failOnError(err, "Failed to register a consumer")

	order_ids := make(chan string)
	go func() {
		for d := range msgs {
			log.Printf("Received a message: %s", d.Body)
			order_ids <- string(d.Body)
		}
		close(order_ids)
	}()

	err = ch.Cancel("orders", false)
	if err != nil {
	    log.Fatalf("basic.cancel: %v", err)
	}

	var order_ids_array []string
	for n := range order_ids {
    	order_ids_array = append(order_ids_array, n)
    }	

    return order_ids_array
}


/*

	-- RabbitMQ Setup
	-- Default User/Pass: guest/guest

	http://localhost:8080

	-- RabbitMQ Create Queue:  

		Queue Name: gumball
		Durable:	no

		> docker exec -it rabbitmq bash 
		> rabbitmqadmin declare queue name=gumball durable=false
		> rabbitmqadmin list queues vhost name node messages 

	-- Gumball MongoDB Create Database

		Database Name: cmpe281
		Collection Name: gumball

  	-- Gumball MongoDB Collection (Create Document) --


	use cmpe281
	show dbs
	
	db.createUser(
   	 {
     	user: "admin",
     	pwd: "cmpe281",  
     	roles: [ "readWrite", "dbAdmin" ]
   	 }
	) ;

    db.gumball.insert(
	    { 
	      Id: 1,
	      CountGumballs: NumberInt(202),
	      ModelNumber: 'M102988',
	      SerialNumber: '1234998871109' 
	    }
	) ;

    -- Gumball MongoDB Collection - Find Gumball Document --

    db.gumball.find( { Id: 1 } ) ;

    {
        "_id" : ObjectId("54741c01fa0bd1f1cdf71312"),
        "Id" : 1,
        "CountGumballs" : 202,
        "ModelNumber" : "M102988",
        "SerialNumber" : "1234998871109"
    }

    -- Gumball MongoDB Collection - Update Gumball Document --

    db.gumball.update( 
        { Id: 1 }, 
        { $set : { CountGumballs : NumberInt(10) } },
        { multi : false } 
    )

    -- Gumball Delete Documents

    db.gumball.remove({})


    -- CURL Tests

	curl localhost:3000/ping
	curl localhost:3000/gumball

	test-place-order:
		curl -X POST \
	  	http://localhost:3000/order \
	  	-H 'Content-Type: application/json'

	test-order-status:
		curl -X GET \
	  	http://localhost:3000/order \
	  	-H 'Content-Type: application/json'

	test-process-order:
		curl -X POST \
	  	http://localhost:3000/orders \
	  	-H 'Content-Type: application/json'


 */
