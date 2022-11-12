/*
	Gumball API in Go (Version 1)
	Basic Version with no Backend Services
*/

package main

import (
	"fmt"
	"net/http"
	"encoding/json"
	"github.com/codegangsta/negroni"
	"github.com/gorilla/mux"
	"github.com/unrolled/render"
	"github.com/satori/go.uuid"
)


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

// API Ping Handler
func pingHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
		formatter.JSON(w, http.StatusOK, struct{ Test string }{"API version 1.0 alive!"})
	}
}

// API Gumball Machine Handler
func gumballHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
		formatter.JSON(w, http.StatusOK, machine)
	}
}

// API Update Gumball Inventory
func gumballUpdateHandler(formatter *render.Render) http.HandlerFunc {
	return func(w http.ResponseWriter, req *http.Request) {
    	var m gumballMachine
    	_ = json.NewDecoder(req.Body).Decode(&m)		
    	fmt.Println("Update Gumball Inventory To: ", m.CountGumballs)
    	machine.CountGumballs = m.CountGumballs
		formatter.JSON(w, http.StatusOK, machine)
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



