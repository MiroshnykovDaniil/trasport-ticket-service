package com.daniil.trasportticketservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Ticket")
@Table(name = "ticket")
@Getter
@Setter
public class Ticket {

    @Id
    String id;

    @ManyToOne
    private Account passenger;

    @ManyToOne
    private Route route;

    @ManyToOne
    private RouteDestination destinationDeparture;
    @ManyToOne
    private RouteDestination destinationArrive;

    private BigDecimal price;
}
