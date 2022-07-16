package com.daniil.trasportticketservice.service;

public interface PassengerTypeService {

    void create(String title, Integer discountPercent);

    void updateDiscount(String id, Integer discountPercentChanged);

    void removeDiscount(String id);

    void delete(String id);
}
