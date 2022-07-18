package com.daniil.trasportticketservice.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity(name = "Route")
@Table(name = "route")
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    private String id;

    @ManyToOne
    private Destination departureDestination;

    @ManyToOne
    private Destination arrivalDestination;

    @OneToMany(cascade=CascadeType.ALL)
    @OrderBy("order")
    private List<RouteDestination> routeDestinations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id) && Objects.equals(routeDestinations, route.routeDestinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeDestinations);
    }


    public void addRouteDestinations(List<RouteDestination> routeDestinations){
        this.routeDestinations = routeDestinations;
        for(int i = 0; i < routeDestinations.size(); i++){
            RouteDestination destination = routeDestinations.get(i);
            destination.setRoute(this);
            destination.setOrder(i);
        }
    }

    public void addRouteDestination(RouteDestination destination) {
        // if order is not specified (=0), or more than latest element, add as last
        if (destination.getOrder().equals(0) || destination.getOrder() >= getRouteDestinations().size()){
            destination.setOrder(getRouteDestinations().size() - 1);
            getRouteDestinations().add(destination);
        }
        else{
            // increment destination order to free needed
            int index = destination.getOrder();
            List<RouteDestination> destinations = getRouteDestinations();
            for(int i = index;i<getRouteDestinations().size();i++){
                destinations.get(i).setOrder(i+1);
            }
            // and add new destination to free order
            destinations.add(index,destination);
        }
    }

    // remove destination and decrement others order
    public void removeRouteDestination(RouteDestination destination){
        int index = destination.getOrder();
        RouteDestination delete = getRouteDestinations().get(index);
        if(delete.equals(destination)){
            getRouteDestinations().remove(destination);
            for(int i = destination.getOrder();i<getRouteDestinations().size(); i++){
                getRouteDestinations().get(i).setOrder(i-1);
            }
        }
    }

}
