package com.daniil.trasportticketservice.service.ticketService;

import com.daniil.trasportticketservice.model.Ticket;
import com.daniil.trasportticketservice.requests.TicketCreateRequest;


public interface TicketService {
    Ticket createTicket(TicketCreateRequest ticketCreateRequest);

}
