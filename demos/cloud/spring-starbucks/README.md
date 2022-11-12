# Starbucks End-to-End Example


## REST API 

Run the provided Starbucks API.  See Demo in class on how to setup, build and run Starbucks API.  Then test using the provided Postman Project.

![postman-project](images/postman-project.png)


The Starbucks API Specification is as follows:

```
Ping Health Check.

GET 	/ping
		

		{
		    "test": "Starbucks API version 3.1 alive!"
		}		


Get a list of Starbucks Cards (along with balances).

GET 	/cards 

		[
		    {
		        "cardNumber": "344329363",
		        "cardCode": "257",
		        "balance": 20.0,
		        "activated": false,
		        "status": "New Card"
		    },
		    {
		        "cardNumber": "323586828",
		        "cardCode": "607",
		        "balance": 20.0,
		        "activated": false,
		        "status": "New Card"
		    }
		]		


Create a new Starbucks Card.

POST 	/cards

		{
		    "cardNumber": "299255600",
		    "cardCode": "903",
		    "balance": 20.0,
		    "activated": false,
		    "status": "New Card"
		}


Get the details of a specific Starbucks Card.

GET 	/cards/{num}

		

		{
		    "cardNumber": "299255600",
		    "cardCode": "903",
		    "balance": 20.0,
		    "activated": false,
		    "status": "New Card"
		}


Activate Card 

POST 	/card/activate/{num}/{code}

		{
		  "CardNumber": "627131848",
		  "CardCode": "547",
		  "Balance": 20,
		  "Activated": true,
		  "Status": ""
		}


Create a new order. Set order as "active" for register.

POST    /order/register/{regid}
        
        Request:

	{
	    "drink": "Caffe Latte",
	    "milk":  "Whole",
	    "size":  "Grande"
	}           

	Response:

	{
	    "drink": "Caffe Latte",
	    "milk": "Whole",
	    "size": "Grande",
	    "total": 3.91,
	    "status": "Ready for Payment.",
	    "register": "5012349"
	}	    


Request the current state of the "active" Order.

GET     /order/register/{regid}
        
	{
	    "drink": "Caffe Latte",
	    "milk": "Whole",
	    "size": "Grande",
	    "total": 3.91,
	    "status": "Ready for Payment.",
	    "register": "5012349"
	}


Clear the "active" Order.

DELETE  /order/register/{regid}
       
	{
	    "Status": "Active Order Cleared!"
	}


Process payment for the "active" Order. 

POST    /order/register/{regid}/pay/{cardnum}
        
        Response: (with updated card balance)

	{
	    "cardNumber": "299255600",
	    "cardCode": "903",
	    "balance": 16.09,
	    "activated": true,
	    "status": "New Card"
	}


Get a list of all active orders (for all registers)

GET     /orders
        
	[
	    {
	        "drink": "Caffe Latte",
	        "milk": "Whole",
	        "size": "Grande",
	        "total": 3.91,
	        "status": "Ready for Payment.",
	        "register": "5012349"
	    },
	    {
	        "drink": "Caffe Latte",
	        "milk": "Whole",
	        "size": "Grande",
	        "total": 3.91,
	        "status": "Paid with Card: 299255600 Balance: $16.09.",
	        "register": "5012349"
	    }
	]


Delete all Cards (Use for Unit Testing Teardown)

DELETE 	/cards

	{
	  "Status": "All Cards Cleared!"
	}


Delete all Orders (Use for Unit Testing Teardown)

DELETE 	/orders	

	{
	  "Status": "All Orders Cleared!"
	}

```


## Example Usage for Starbucks Mobile App Simulator


![1-starbucks-screen-flows](images/starbucks-screen-flows.png)

![2.starbucks-pin-screen](images/starbucks-pin-screen.png)

![3.starbucks-making-payments](images/starbucks-making-payments.png)


## Explore the Sample Node.js and Java Mobile App Simulator

Run these Apps against the Starbucks API and explore how they work.

## Example Workflow

### Run Starbucks API 

* Launch via Docker Image:  paulnguyen/spring-starbucks-api

```
	docker network create --driver bridge starbucks

	docker run --network starbucks --name spring-starbucks-api -td -p 8080:8080 \
	--platform=linux/amd64 paulnguyen/spring-starbucks-api	

```

### Starbucks App (Mobile App Simulator)

* Requires Gradle 4.9 and Java JDK 8
* Launch and Login with PIN: 1234 
	* touch(1,5), touch(2,5), touch(3,5) and touch(1,6)
	* or just use the "login" shortcut 

* Starbucks App Pin Screen

![starbucks-app](images/starbucks-app.png)

* Main Screen After Login

![starbucks-app-post-login](images/starbucks-app-post-login.png)


### Placing an Order on the Starbucks Cash Register (Node.js App)

* Run via Docker Image: paulnguyen/starbucks-nodejs

```
	docker run --network starbucks --name starbucks-nodejs -td -p 90:9090  \
	-e "api_endpoint=http://spring-starbucks-api:8080" \
	--platform=linux/amd64 paulnguyen/starbucks-nodejs
```

* Cashier App

![nodejs-cashier-app](images/nodejs-cashier-app.png)

* Cashier App (Order Placed)

![nodejs-place-order](images/nodejs-place-order.png)


### Paying on the Starbucks App

* touch(3,3) to switch to "pay screen"

![starbucks-pay-screen](images/starbucks-pay-screen.png)

* touch(2,2) to pay

![starbucks-make-payment](images/starbucks-make-payment.png)

* touch(3,3) to see balance on Starbucks Card after payment

![starbucks-app-paid-balance](images/starbucks-app-paid-balance.png)

6. Check Starbucks Cash Register for Successful Payment (Node.js App)

* Click on "Get Order" to Refresh UI

![starbucks-register-paid-for-order](images/starbucks-register-paid-for-order.png)

7. Sample REST API Calls from Postman (List Cards)

![rest-api-cards](images/rest-api-cards.png)

8. Sample REST API Calls from Postman (List Orders)

![rest-api-orders](images/rest-api-orders.png)



# Reference

* http://kong.github.io/unirest-java
* https://www.baeldung.com/unirest
* http://stleary.github.io/JSON-java/index.html
* https://www.programcreek.com/java-api-examples/?api=com.mashape.unirest.http.Unirest







