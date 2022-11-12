/*
	Gumball API in Go (Version 1)
	Basic Version with no Backend Services
*/
	
package main

type gumballMachine struct {
	Id             	int 	
	CountGumballs   int    	
	ModelNumber 	string	    
	SerialNumber 	string	
}

var machine gumballMachine = gumballMachine {
  	Id: 1,
	CountGumballs: 10000,
	ModelNumber: "M102988",
	SerialNumber: "1234998871109",
}

type order struct {
	Id             	string 	
	OrderStatus 	string	
}

var orders map[string] order
