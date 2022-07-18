package com.daniil.trasportticketservice.service.destination;

import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;

public interface DestinationService {

    Destination addDestination(String title);

    Destination addRoute(String destinationId,String routeId);

    Destination removeRoute(String destinationId,String routeId);

}
