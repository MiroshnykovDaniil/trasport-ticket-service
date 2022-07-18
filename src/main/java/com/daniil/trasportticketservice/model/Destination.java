package com.daniil.trasportticketservice.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Destination")
@Table(name = "destination")
@Getter
@Setter
public class Destination {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    private String id;
    private String title;

    //@ManyToMany(mappedBy = "routeDestinations")
    //private Set<Route> routes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title); //&& Objects.equals(routes, that.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
