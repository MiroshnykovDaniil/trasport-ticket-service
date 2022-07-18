package com.daniil.trasportticketservice.service.passengerType;

import com.daniil.trasportticketservice.model.PassengerType;
import com.daniil.trasportticketservice.repository.PassengerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PassengerTypeServiceImpl implements PassengerTypeService{

    @Autowired
    private PassengerTypeRepository repository;

    @Override
    public PassengerType create(String title, Integer discountPercent) {
        PassengerType passengerType = new PassengerType();
        passengerType.setTitle(title);
        passengerType.setDiscountPercent(discountPercent);
        return repository.save(passengerType);
    }

    @Override
    public PassengerType updateDiscount(String id, Integer discountPercentChanged) {
        PassengerType passengerType = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PassengerType:"+"id:"+id));
        passengerType.setDiscountPercent(discountPercentChanged);
        return repository.save(passengerType);
    }

    @Override
    public PassengerType removeDiscount(String id) {
        PassengerType passengerType = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PassengerType:"+"id:"+id));
        passengerType.setDiscountPercent(0);
        return repository.save(passengerType);
    }

    @Override
    public PassengerType get(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PassengerType:"+"id:"+id));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
