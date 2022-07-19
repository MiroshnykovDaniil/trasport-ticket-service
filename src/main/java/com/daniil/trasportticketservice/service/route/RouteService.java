package com.daniil.trasportticketservice.service.route;

import com.daniil.trasportticketservice.dto.RouteDestinationDto;
import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.model.RouteDestination;

import java.util.List;

public interface RouteService {

    Route createRoute(Destination departure, Destination arrival, List<RouteDestination> destinations);

    void deleteRoute(Route route);
    //Route setDestinations(String id,List<RouteDestination> destinations);

    Route addDestination(Route route, RouteDestination destination);

    Route removeDestination(Route route, RouteDestination destination);

    Route updateDestination(Route route, RouteDestination destination);

    Route getRoute(String id);


}
