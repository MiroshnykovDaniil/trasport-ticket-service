package com.daniil.trasportticketservice.repository;

import com.daniil.trasportticketservice.model.Route;
import com.daniil.trasportticketservice.model.RouteDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface RouteRepository extends JpaRepository<Route,String> {


}
