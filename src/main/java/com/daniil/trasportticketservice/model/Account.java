package com.daniil.trasportticketservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Account")
@Table(name = "account")
@Getter
@Setter
public class Account {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private PassengerType passengerType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name) && Objects.equals(passengerType, account.passengerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passengerType);
    }

    //    @Column(name = "is_child")
//    private Boolean isChild;
//
//    @Column(name = "is_student")
//    private Boolean isStudent;
//
//    @Column(name = "is_senior")
//    private Boolean isSenior;


}