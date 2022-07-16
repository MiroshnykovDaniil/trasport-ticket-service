package com.daniil.trasportticketservice.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Ticket")
@Table(name = "ticket")
public class Ticket {

    @Id
    String id;

    @ManyToOne
    private Account passenger;

    @ManyToOne
    private Route route;

    @ManyToOne
    private Destination destinationDeparture;
    @ManyToOne
    private Destination destinationArrive;

    private BigDecimal price;
}
