package com.daniil.trasportticketservice.repository;

import com.daniil.trasportticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket,String> {
}
