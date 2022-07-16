package com.daniil.trasportticketservice.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PassengerType")
@Table(name = "passenger_type")
public class PassengerType {

    @Id
    private String id;
    private String title;

    private Integer discountPercent;

}
