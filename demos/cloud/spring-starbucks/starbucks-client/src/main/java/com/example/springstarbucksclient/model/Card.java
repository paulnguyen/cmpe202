package com.example.springstarbucksclient.model;

/*
        {
            "cardNumber": "553915048",
            "cardCode": "408",
            "balance": 20.0,
            "activated": false,
            "status": "New Card"
        }
*/

import lombok.Data;

@Data
public class Card {
    private String cardNumber ;
    private String cardCode ;
    private double balance ;
    private boolean activated ;
    private String status ;
}
