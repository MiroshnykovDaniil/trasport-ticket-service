package com.daniil.trasportticketservice.service.ticketService;

import com.daniil.trasportticketservice.model.Account;
import com.daniil.trasportticketservice.model.Ticket;
import com.daniil.trasportticketservice.requests.TicketCreateRequest;

import java.util.List;

public interface TicketService {
    Ticket createTicket(TicketCreateRequest ticketCreateRequest);

}
