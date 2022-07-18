package com.daniil.trasportticketservice.service.passengerType;

import com.daniil.trasportticketservice.model.PassengerType;

public interface PassengerTypeService {

    PassengerType create(String title, Integer discountPercent);

    PassengerType updateDiscount(String id, Integer discountPercentChanged);

    PassengerType removeDiscount(String id);

    PassengerType get(String id);

    void delete(String id);
}
