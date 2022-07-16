package com.daniil.trasportticketservice.model;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RouteDestinationPrimaryKey implements Serializable {

    String routeId;
    String destinationId;
}
