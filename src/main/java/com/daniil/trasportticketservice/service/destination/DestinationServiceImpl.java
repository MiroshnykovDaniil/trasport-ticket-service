package com.daniil.trasportticketservice.service.destination;

import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.repository.DestinationRepository;
import com.daniil.trasportticketservice.service.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinationServiceImpl implements DestinationService{

    @Autowired
    private DestinationRepository repository;

    @Autowired
    private RouteService routeService;

    @Override
    public Destination addDestination(String title) {
        Destination destination = new Destination();
        destination.setTitle(title);
        return repository.save(destination);
    }

    @Override
    public Destination addRoute(String destinationId,String routeId) {
        Route route = routeService.getRoute(routeId);
        Destination destination = repository.findById(destinationId).orElseThrow();
        return repository.save(destination);
    }

    @Override
    public Destination removeRoute(String destinationId,String routeId) {
        Route route = routeService.getRoute(routeId);
        Destination destination = repository.findById(destinationId).orElseThrow();
        return repository.save(destination);
    }
}
