package com.daniil.trasportticketservice.service.passengerType;

import com.daniil.trasportticketservice.model.PassengerType;

public interface PassengerTypeService {

    PassengerType create(String title, Integer discountPercent);

    PassengerType updateDiscount(PassengerType passengerType, Integer discountPercentChanged);

    PassengerType removeDiscount(PassengerType passengerType);

    PassengerType get(String id);

    void delete(PassengerType passengerType);
}
