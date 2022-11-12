package com.example.springstarbucksclient;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class ConsoleCommand {

    private String action ;
    private String cardnum ;
    private String cardcode ;
    private String message ;

}

