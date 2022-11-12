package com.example.springstarbucksapi.rest;

import com.example.springstarbucksapi.model.StarbucksCard;
import com.example.springstarbucksapi.model.StarbucksOrder;
import com.example.springstarbucksapi.service.StarbucksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/* 
    https://spring.io/guides/tutorials/rest/ 
    https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration
*/

@RestController
public class StarbucksOrderController {

    // REF: https://www.moreofless.co.uk/spring-mvc-java-autowired-component-null-repository-service
    @Autowired private StarbucksService service ;

    static class Message {
        private String status;
        public String getStatus() {
            return status;
        }
        public void setStatus(String msg) {
            status = msg;
        }
    }

    /* Get List of Starbucks Orders */
    @GetMapping("/orders")
    List<StarbucksOrder> all() {
        return service.allOrders() ;
    }

    /* Delete All Starbucks Orders (Cleanup for Unit Testing) */
    @DeleteMapping("/orders")
    Message deleteAll() {
        service.deleteAllOrders();
        Message msg = new Message();
        msg.setStatus("All Orders Cleared!");
        return msg;
    }

    /* Create a New Starbucks Order */
    @PostMapping("/order/register/{regid}")
    @ResponseStatus(HttpStatus.CREATED)
    StarbucksOrder newOrder(@PathVariable String regid, @RequestBody StarbucksOrder order) {
        return service.newOrder(regid, order) ;
    }

    /* Get Details of a Starbucks Order */
    @GetMapping("/order/register/{regid}")
    StarbucksOrder getActiveOrder(@PathVariable String regid, HttpServletResponse response) {
        StarbucksOrder active = service.getActiveOrder(regid) ;
        if (active != null) {
            return active;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order Not Found!");
        }
    }

    /* Clear Active Order */
    @DeleteMapping("/order/register/{regid}")
    Message deleteActiveOrder(@PathVariable String regid) {
        StarbucksOrder active = service.getActiveOrder(regid);
        if (active != null) {
            service.clearActiveOrder(regid);
            Message msg = new Message();
            msg.setStatus("Active Order Cleared!");
            return msg;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order Not Found!");
        }
    }

    /*  Process payment for the "active" Order. */
    @PostMapping("/order/register/{regid}/pay/{cardnum}")
    StarbucksCard processOrder(@PathVariable String regid, @PathVariable String cardnum) {
        return service.processOrder(regid, cardnum) ;
    }

}



/*

https://priceqube.com/menu-prices/%E2%98%95-starbucks

var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" ];
var MILK_OPTIONS  = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" ];
var SIZE_OPTIONS  = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];

Caffè Latte
=============
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Caffè Americano
===============
tall 	$2.25
grande 	$2.65
venti 	$2.95 (Your Own Cup)

Caffè Mocha
=============
tall 	$3.45
grande 	$4.15
venti 	$4.45 (Your Own Cup)

Cappuccino
==========
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Espresso
========
short 	$1.75
tall 	$1.95


POST    /order/register/{regid}
        Create a new order. Set order as "active" for register.

        Request:

	    {
	      "Drink": "Latte",
	      "Milk":  "Whole",
	      "Size":  "Grande"
	    }         

	    Response:

		{
		  "Drink": "Latte",
		  "Milk": "Whole",
		  "Size": "Grande",
		  "Total": 2.413125,
		  "Status": "Ready for Payment."
		}	    

GET     /order/register/{regid}
        Request the current state of the "active" Order.

		{
		  "Drink": "Latte",
		  "Milk": "Whole",
		  "Size": "Grande",
		  "Total": 2.413125,
		  "Status": "Ready for Payment."
		}

DELETE  /order/register/{regid}
        Clear the "active" Order.

		{
		  "Status": "Active Order Cleared!"
		}

POST    /order/register/{regid}/pay/{cardnum}
        Process payment for the "active" Order. 

        Response: (with updated card balance)

		{
		  "CardNumber": "627131848",
		  "CardCode": "547",
		  "Balance": 15.17375,
		  "Activated": true,
		  "Status": ""
		}

GET     /orders
        Get a list of all active orders (for all registers)

		{
		  "5012349": {
		    "Drink": "Latte",
		    "Milk": "Whole",
		    "Size": "Grande",
		    "Total": 4.82625,
		    "Status": "Paid with Card: 627131848 Balance: $15.17."
		  }
		}

DELETE 	/orders
		Delete all Orders (Use for Unit Testing Teardown)

		{
		  "Status": "All Orders Cleared!"
		}

*/