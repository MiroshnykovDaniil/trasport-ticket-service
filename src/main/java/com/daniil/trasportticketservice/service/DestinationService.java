package com.daniil.trasportticketservice.service;

import com.daniil.trasportticketservice.model.Route;

public interface DestinationService {

    void addDestination(String title);

    void addRoute(Route route);

    void removeRoute(Route route);

}
