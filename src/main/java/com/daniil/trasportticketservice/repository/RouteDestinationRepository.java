package com.daniil.trasportticketservice.repository;

import com.daniil.trasportticketservice.model.RouteDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public interface RouteDestinationRepository extends JpaRepository<RouteDestination, String> {

}
