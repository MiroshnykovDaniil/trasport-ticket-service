package com.daniil.trasportticketservice.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Route")
@Table(name = "route")
public class Route {

    @Id
    private String id;

    @OneToMany
    @OrderBy("order")
    private List<RouteDestinations> routeDestinations;

}
