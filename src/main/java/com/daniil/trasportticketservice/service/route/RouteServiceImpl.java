package com.daniil.trasportticketservice.service.route;

import com.daniil.trasportticketservice.dto.TicketPriceDuration;
import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.model.RouteDestination;
import com.daniil.trasportticketservice.repository.RouteRepository;
import com.daniil.trasportticketservice.service.routeDestination.RouteDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteRepository repository;
//    @Autowired
//    private RouteDestinationService routeDestinationService;

    @Override
    public Route createRoute(Destination departure, Destination arrival, List<RouteDestination> destinations) {
        Route route = new Route();
        route.setDepartureDestination(departure);
        route.setArrivalDestination(arrival);
        route.addRouteDestinations(destinations);
        return repository.save(route);
    }

    @Override
    public void deleteRoute(Route route) {
        repository.delete(route);
    }

    public Route setDestinations(String id, List<RouteDestination> destinations) {
        Route route = repository.findById(id).orElseThrow();
        route.setRouteDestinations(destinations);
        return repository.save(route);
    }

    @Override
    public Route addDestination(Route route, RouteDestination destination) {
        route = repository.findById(route.getId()).orElseThrow();
        route.addRouteDestination(destination);
        return repository.save(route);
    }

    @Override
    public Route removeDestination(Route route, RouteDestination destination) {
        route = repository.findById(route.getId()).orElseThrow();
        route.removeRouteDestination(destination);
        return repository.save(route);
    }

    @Override
    public Route updateDestination(Route route, RouteDestination destination) {
        RouteDestination routeDestination = route.getRouteDestinations().get(destination.getOrder());
        if (routeDestination.getId().equals(destination.getId())){
        }
        return route;
    }

    @Override
    public Route getRoute(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public TicketPriceDuration getRoutePriceDuration(Route route, RouteDestination departure, RouteDestination arrival) {
        route = getRoute(route.getId());
        BigDecimal price = new BigDecimal("0");
        Duration duration = Duration.ZERO;
        for(int i = departure.getOrder(); i<arrival.getOrder();i++){
            RouteDestination routeDestination = route.getRouteDestinations().get(i);
            price = price.add(routeDestination.getPriceToArrive());
            duration = duration.plus(routeDestination.getArriveDuration());
        }
        TicketPriceDuration ticketPriceDuration = new TicketPriceDuration(price,duration);
        return ticketPriceDuration;
    }


}
