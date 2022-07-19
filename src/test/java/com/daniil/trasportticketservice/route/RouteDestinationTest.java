package com.daniil.trasportticketservice.route;


import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.model.RouteDestination;
import com.daniil.trasportticketservice.repository.DestinationRepository;
import com.daniil.trasportticketservice.repository.RouteDestinationRepository;
import com.daniil.trasportticketservice.service.route.RouteService;
import com.daniil.trasportticketservice.service.routeDestination.RouteDestinationService;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"DB_USER = root","DB_PASS = "})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RouteDestinationTest {

    @Autowired
    RouteService routeService;
    @Autowired
    RouteDestinationService routeDestinationService;

    @Autowired
    DestinationRepository destinationRepository;

    @Test
    public void getRouteDestinations(){
        Route route = new Route();
        Destination departure, arrive, destination;

        List<RouteDestination> routeDestinations;
        departure = new Destination();
        departure.setTitle("Lviv");
        arrive = new Destination();
        arrive.setTitle("Odesa");
        destination = new Destination();
        destination.setTitle("Dnipro");
        destinationRepository.saveAll(List.of(departure,destination,arrive));
        departure = destinationRepository.findByTitle("Kharkiv");
        arrive = destinationRepository.findByTitle("Kyiv");
        destination = destinationRepository.findByTitle("Poltava");

        RouteDestination dep = new RouteDestination();
        dep.setDestination(departure);

        RouteDestination dest = new RouteDestination();
        dest.setDestination(destination);
        dest.setArriveDuration(Duration.ofHours(3));
        dest.setPriceToArrive(BigDecimal.valueOf(150));

        RouteDestination arr = new RouteDestination();
        arr.setDestination(arrive);
        arr.setArriveDuration(Duration.ofHours(2));
        arr.setPriceToArrive(BigDecimal.valueOf(170));

        routeDestinations = new ArrayList<>();
        routeDestinations.addAll(List.of(dep,dest,arr));

        route = routeService.createRoute(departure,destination, routeDestinations);

        routeDestinations = routeDestinationService.getRouteDestinations(route);
        assertThat(routeDestinations.isEmpty()).isFalse();

    }
}
