package com.daniil.trasportticketservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity(name = "Destination")
@Table(name = "destination")
public class Destination {

    @Id
    private String id;
    private String title;

    @ManyToMany(mappedBy = "routeDestinations")
    private Set<Route> routes;
}
