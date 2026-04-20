package org.example.java_web_hackathon.model;

import java.time.LocalDateTime;

public class Flight {
    private Long id;
    private String flightNumber;
    private String destination;
    private LocalDateTime departureTime;
    private Double ticketPrice;
    private String airlineLogo;

    public Flight() {
    }

    public Flight(Long id, String flightNumber, String destination, LocalDateTime departureTime, Double ticketPrice, String airlineLogo) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
        this.airlineLogo = airlineLogo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getAirlineLogo() {
        return airlineLogo;
    }

    public void setAirlineLogo(String airlineLogo) {
        this.airlineLogo = airlineLogo;
    }
}
