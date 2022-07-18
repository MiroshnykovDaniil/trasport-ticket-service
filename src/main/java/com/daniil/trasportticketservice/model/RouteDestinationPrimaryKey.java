package com.daniil.trasportticketservice.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RouteDestinationPrimaryKey implements Serializable {

//    @Column(name = "route_id")
//    String routeId;

    @Column(name = "destination_id")
    String destinationId;

//    public String getRouteId() {
//        return routeId;
//    }

//    public void setRouteId(String routeId) {
//        this.routeId = routeId;
//    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }
}
