package com.daniil.trasportticketservice.model;


import javax.persistence.*;

@Entity(name = "Account")
@Table(name = "account")
public class Account {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private PassengerType passengerType;

//    @Column(name = "is_child")
//    private Boolean isChild;
//
//    @Column(name = "is_student")
//    private Boolean isStudent;
//
//    @Column(name = "is_senior")
//    private Boolean isSenior;


}