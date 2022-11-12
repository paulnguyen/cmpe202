/*
	Gumball API in Go (Version 2)
	Uses MongoDB and RabbitMQ 
*/
	
package main

import (
	"os"
)

func main() {

	port := os.Getenv("PORT")
	if len(port) == 0 {
		port = "3000"
	}

	server := NewServer()
	server.Run(":" + port)
}
