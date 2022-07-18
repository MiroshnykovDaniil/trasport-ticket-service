package com.daniil.trasportticketservice.service.routeDestination;

import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.model.RouteDestination;
import com.daniil.trasportticketservice.repository.RouteDestinationRepository;
import com.daniil.trasportticketservice.service.route.RouteService;

import java.math.BigDecimal;
import java.util.List;

public class RouteDestinationServiceImpl implements RouteDestinationService{

    private RouteService routeService;

    private RouteDestinationRepository routeDestinationRepository;


    @Override
    public RouteDestination add(Route route, Destination destination, BigDecimal priceToArrive) {
        List<RouteDestination> routeDestinations = route.getRouteDestinations();

        RouteDestination routeDestination = new RouteDestination();
        routeDestination.setDestination(destination);
        routeDestination.setPriceToArrive(priceToArrive);
        routeDestination.setOrder(routeDestinations.size());

        routeDestinationRepository.save(routeDestination);
        routeDestinations.add(routeDestination);
        routeService.addDestination(route,routeDestination);

        return null;
    }

    public void addToPosition(Route route, RouteDestination destination, Integer position){

    }

    private void insertDestinationToPosition(List<RouteDestination> routeDestinations, RouteDestination destination){
        routeDestinations.add(destination.getOrder(),destination);
        routeDestinations.subList(destination.getOrder(), routeDestinations.size()).forEach(
                destinationPosChange -> destinationPosChange.setOrder(destinationPosChange.getOrder()+1)
        );
        routeDestinationRepository.saveAll(routeDestinations);
    }
}
