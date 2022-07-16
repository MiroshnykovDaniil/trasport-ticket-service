package com.daniil.trasportticketservice.model;



import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "RouteDestinations")
@Table(name = "route_destinations")
public class RouteDestinations {

    @EmbeddedId
    private RouteDestinationPrimaryKey id;

    @ManyToOne
    private Route route;

    @MapsId("destinationId")
    @ManyToOne
    private Destination destination;

    @MapsId("routeId")
    private BigDecimal priceToArrive;

    private Integer order;

}