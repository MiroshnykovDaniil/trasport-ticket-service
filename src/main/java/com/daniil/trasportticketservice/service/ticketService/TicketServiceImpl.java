package com.daniil.trasportticketservice.service.ticketService;

import com.daniil.trasportticketservice.model.Ticket;
import com.daniil.trasportticketservice.repository.TicketRepository;
import com.daniil.trasportticketservice.requests.TicketCreateRequest;
import com.daniil.trasportticketservice.service.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;


public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private RouteService routeService;

    @Override
    public Ticket createTicket(TicketCreateRequest ticketCreateRequest) {
        Ticket ticket = new Ticket();
        ticket.setRoute((ticketCreateRequest.getRoute()));
        ticket.setPassenger(ticketCreateRequest.getPassenger());
        ticket.setRoute(ticketCreateRequest.getRoute());
        ticket.setDestinationDeparture(ticketCreateRequest.getDestinationDeparture());
        ticket.setDestinationArrive(ticketCreateRequest.getDestinationArrive());

        ticket.setPrice(
                routeService.getRoutePriceDuration(
                        ticketCreateRequest.getRoute(),
                        ticketCreateRequest.getDestinationDeparture(),
                        ticketCreateRequest.getDestinationArrive()).getPrice());
        return ticketRepository.save(ticket);
    }

}
