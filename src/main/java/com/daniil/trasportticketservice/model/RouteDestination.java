package com.daniil.trasportticketservice.model;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;

@Entity(name = "RouteDestinations")
@Table(name = "route_destinations")
@Getter
@Setter
public class RouteDestination {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    private String id;

//    @EmbeddedId
//    private RouteDestinationPrimaryKey fk = new RouteDestinationPrimaryKey();

  //  @MapsId("destinationId")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Destination destination;

    //@MapsId("routeId")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Route route;

    private BigDecimal priceToArrive = BigDecimal.ZERO;

    @Column(name = "destination_order")
    private Integer order;

    private Duration arriveDuration = Duration.ZERO;

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }


    public BigDecimal getPriceToArrive() {
        return priceToArrive;
    }

    public void setPriceToArrive(BigDecimal priceToArrive) {
        this.priceToArrive = priceToArrive;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Duration getArriveDuration() {
        return arriveDuration;
    }

    public void setArriveDuration(Duration arriveDuration) {
        this.arriveDuration = arriveDuration;
    }
}