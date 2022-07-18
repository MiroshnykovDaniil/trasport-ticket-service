package com.daniil.trasportticketservice.repository;

import com.daniil.trasportticketservice.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,String> {


    Destination findByTitle(String title);
}
