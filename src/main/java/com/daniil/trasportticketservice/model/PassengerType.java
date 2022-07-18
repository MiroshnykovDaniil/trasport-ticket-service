package com.daniil.trasportticketservice.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity(name = "PassengerType")
@Table(name = "passenger_type")
@Getter
@Setter
public class PassengerType {

    @Id
    private String id;
    private String title;

    private Integer discountPercent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerType that = (PassengerType) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(discountPercent, that.discountPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, discountPercent);
    }
}
