package com.example.springstarbucksapi.rest;

import com.example.springstarbucksapi.model.StarbucksCard;
import com.example.springstarbucksapi.service.StarbucksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/* https://spring.io/guides/tutorials/rest/ */

@RestController
public class StarbucksCardController {

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

    /* Create a New Starbucks Card */
    @PostMapping("/cards")
    @ResponseStatus(HttpStatus.CREATED)
    StarbucksCard newCard() {
        return service.newCard() ;
    }

    /* Get List of Starbucks Cards */
    @GetMapping("/cards")
    List<StarbucksCard> all() {
        return service.allCards();
    }

    /* Delete All Starbucks Cards (Cleanup for Unit Testing) */
    @DeleteMapping("/cards")
    Message deleteAll() {
        service.deleteAllCards() ;
        Message msg = new Message();
        msg.setStatus("All Cards Cleared!");
        return msg;
    }

	/*
	  https://www.baeldung.com/spring-pathvariable
	  https://www.baeldung.com/exception-handling-for-rest-with-spring
	*/

    /* Get Details of a Starbucks Card */
    @GetMapping("/card/{num}")
    StarbucksCard getOne(@PathVariable String num, HttpServletResponse response) {
        StarbucksCard card = service.findCard(num);
        if (card == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card Not Found!");
        return card;
    }

    /* Activate a Starbucks Card */
    @PostMapping("/card/activate/{num}/{code}")
    StarbucksCard activate(@PathVariable String num, @PathVariable String code, HttpServletResponse response) {
        StarbucksCard card = service.findCard(num);
        if (card == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card Not Found!");
        if (card.getCardCode().equals(code)) {
            service.activateCard(num, code);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card Not Valid!");
        }
        return card;
    }


}

/*

GET 	/ping
		Ping Health Check.

		{
		  "Test": "Starbucks API version 1.0 alive!"
		}

GET 	/cards
		Get a list of Starbucks Cards (along with balances).

		[
		  {
		    "CardNumber": "498498082",
		    "CardCode": "425",
		    "Balance": 20,
		    "Activated": false,
		    "Status": ""
		  },
		  {
		    "CardNumber": "627131848",
		    "CardCode": "547",
		    "Balance": 20,
		    "Activated": false,
		    "Status": ""
		  }
		]

POST 	/cards
		Create a new Starbucks Card.

		{
		  "CardNumber": "498498082",
		  "CardCode": "425",
		  "Balance": 20,
		  "Activated": false,
		  "Status": "New Card."
		}

GET 	/card/{num}
		Get the details of a specific Starbucks Card.

		{
		  "CardNumber": "627131848",
		  "CardCode": "547",
		  "Balance": 20,
		  "Activated": false,
		  "Status": ""
		}

POST 	/card/activate/{num}/{code}
		Activate Card

		{
		  "CardNumber": "627131848",
		  "CardCode": "547",
		  "Balance": 20,
		  "Activated": true,
		  "Status": ""
		}

DELETE 	/cards
		Delete all Cards (Use for Unit Testing Teardown)

		{
		  "Status": "All Cards Cleared!"
		}

*/