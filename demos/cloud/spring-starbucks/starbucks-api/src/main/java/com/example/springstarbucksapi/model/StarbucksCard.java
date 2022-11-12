package com.example.springstarbucksapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/* 
    https://www.baeldung.com/intro-to-project-lombok
    https://www.baeldung.com/lombok-ide

    https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#mapping.fundamentals
    https://www.baeldung.com/jpa-indexes    
*/

@Entity
@Table(name = "STARBUCKS_CARD", indexes = @Index(name = "altIndex", columnList = "cardNumber", unique = true))
@Data
@RequiredArgsConstructor
public class StarbucksCard {

    private @Id
    @GeneratedValue
    @JsonIgnore  /* https://www.baeldung.com/jackson-ignore-properties-on-serialization */
    Long id;

    @Column(nullable = false)
    private String cardNumber;
    @Column(nullable = false)
    private String cardCode;
    @Column(nullable = false)
    private double balance;
    @Column(nullable = false)
    private boolean activated;
    private String status;

    public boolean isActivated() {
        return activated == true;
    }

}


