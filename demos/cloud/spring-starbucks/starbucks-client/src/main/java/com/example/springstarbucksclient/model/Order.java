package com.example.springstarbucksclient.model;

import lombok.Data;

/*
        {
            "drink": "Caffe Latte",
            "milk": "Whole",
            "size": "Grande",
            "total": 3.91,
            "status": "Ready for Payment.",
            "register": "5012349"
        }
 */

@Data
public class Order {
    private String drink;
    private String milk;
    private String size;
    private double total;
    private String status;
    private String register;
}
