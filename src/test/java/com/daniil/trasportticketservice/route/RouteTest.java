package com.daniil.trasportticketservice.route;

import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.model.RouteDestination;
import com.daniil.trasportticketservice.repository.DestinationRepository;
import com.daniil.trasportticketservice.service.route.RouteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"DB_USER = root","DB_PASS = "})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RouteTest {

    @Autowired
    RouteService routeService;
    @Autowired
    DestinationRepository destinationRepository;

    Destination departure, arrive, destination;

    List<RouteDestination> routeDestinations;
    @Before
    public void setup(){
    }

    Route route;
    @Test
    @Order(1)
    public void createRoute(){
        departure = new Destination();
        departure.setTitle("Kharkiv");
        arrive = new Destination();
        arrive.setTitle("Kyiv");
        destination = new Destination();
        destination.setTitle("Poltava");
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
        assertThat(route.getId()).isNotNull();
        id = route.getId();
    }
    private static String id = "";

    @Test(expected = NoSuchElementException.class)
    @Order(3)
    @Transactional
    public void deleteRoute(){
        //route = routeService.createRoute(departure,destination, routeDestinations);
        route = routeService.getRoute(id);
        routeService.deleteRoute(route);
        routeService.getRoute(route.getId());
    }

    @Test
    @Order(2)
    @Transactional
    public void removeDestination(){
        route = routeService.getRoute(id);
        List<RouteDestination> destinations = route.getRouteDestinations();
        routeService.removeDestination(route,destinations.get(0));
    }

//    @After
//    public void deleteData(){
//    }
}
