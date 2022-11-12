/*
	Gumball API in Go (Version 2)
	Uses MongoDB and RabbitMQ 
*/
	
package main

type gumballMachine struct {
	Id             	int 	
	CountGumballs   int    	
	ModelNumber 	string	    
	SerialNumber 	string	
}

type order struct {
	Id             	string 	
	OrderStatus 	string	
}

var orders map[string] order
