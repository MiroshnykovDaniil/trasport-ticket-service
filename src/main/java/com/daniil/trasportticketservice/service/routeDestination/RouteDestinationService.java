package com.daniil.trasportticketservice.service.routeDestination;

import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.model.RouteDestination;

import java.math.BigDecimal;
import java.util.List;

public interface RouteDestinationService {

    RouteDestination add(Route route, Destination destination, BigDecimal priceToArrive);

    //List<RouteDestination>

}
