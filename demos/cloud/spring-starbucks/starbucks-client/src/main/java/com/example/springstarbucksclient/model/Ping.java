package com.example.springstarbucksclient.model;

import lombok.Data;

/*
        {
            "test": "Starbucks API version 3.1 alive!"
        }
 */

@Data
public class Ping {
    private String test ;
}
