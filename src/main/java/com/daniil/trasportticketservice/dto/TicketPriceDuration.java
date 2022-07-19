package com.daniil.trasportticketservice.dto;

import java.math.BigDecimal;
import java.time.Duration;

public class TicketPriceDuration {

    private BigDecimal price;
    private Duration duration;

    public TicketPriceDuration(BigDecimal price, Duration duration) {
        this.price = price;
        this.duration = duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
