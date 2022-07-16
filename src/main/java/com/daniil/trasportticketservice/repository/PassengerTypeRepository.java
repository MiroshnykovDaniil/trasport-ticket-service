package com.daniil.trasportticketservice.repository;

import com.daniil.trasportticketservice.model.PassengerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTypeRepository extends JpaRepository<PassengerType,String> {

}
