package com.daniil.trasportticketservice.requests;

import com.daniil.trasportticketservice.model.Account;
import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.model.RouteDestination;

public class TicketCreateRequest {

    private Account passenger;
    private Route route;
    private RouteDestination destinationDeparture;
    private RouteDestination destinationArrive;


    public Account getPassenger() {
        return passenger;
    }

    public void setPassenger(Account passenger) {
        this.passenger = passenger;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public RouteDestination getDestinationDeparture() {
        return destinationDeparture;
    }

    public void setDestinationDeparture(RouteDestination destinationDeparture) {
        this.destinationDeparture = destinationDeparture;
    }

    public RouteDestination getDestinationArrive() {
        return destinationArrive;
    }

    public void setDestinationArrive(RouteDestination destinationArrive) {
        this.destinationArrive = destinationArrive;
    }
}
