package com.example.springstarbucksapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/* 
    https://www.baeldung.com/intro-to-project-lombok
    https://www.baeldung.com/lombok-ide
            
    Spring JPA References:

    https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html
    https://docs.spring.io/spring-data/jpa/docs/2.5.1/api
    https://www.baeldung.com/spring-data-rest-relationships
    https://www.baeldung.com/hibernate-one-to-many
    https://www.baeldung.com/jpa-one-to-one
    https://www.baeldung.com/jpa-cascade-types
    https://www.baeldung.com/category/persistence/tag/jpa

*/

@Entity
@Table(name = "STARBUCKS_ORDER")
@Data
@RequiredArgsConstructor
public class StarbucksOrder {

    private @Id
    @GeneratedValue
    @JsonIgnore  /* https://www.baeldung.com/jackson-ignore-properties-on-serialization */
    Long id;
    @Column(nullable = false)
    private String drink;
    @Column(nullable = false)
    private String milk;
    @Column(nullable = false)
    private String size;
    private double total;
    private String status;
    private String register;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    @JsonIgnore  /* https://www.baeldung.com/jackson-ignore-properties-on-serialization */
    private StarbucksCard card;


}

