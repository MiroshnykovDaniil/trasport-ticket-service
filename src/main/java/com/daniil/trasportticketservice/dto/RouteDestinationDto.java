package com.daniil.trasportticketservice.dto;

import com.daniil.trasportticketservice.model.Destination;
import com.daniil.trasportticketservice.model.RouteDestination;

import java.math.BigDecimal;

public class RouteDestinationDto {

    private Destination destination;
    private BigDecimal priceToArrive;
    private Integer order;


}
