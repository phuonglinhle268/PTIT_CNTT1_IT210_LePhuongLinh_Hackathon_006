package org.example.java_web_hackathon.dto;

import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class FlightDTO {
    @NotBlank(message = "Số hiệu chuyến bay không được để trống")
    @Size(min = 5, max = 20, message = "Độ dài từ 5-20 kí tự")
    @Pattern(regexp = "^[A-Za-z]{2}\\d+$")
    private String flightNumber;

    @NotBlank(message = "Điểm đến không được để trống")
    private String destination;

    @DecimalMin(value = "100.0", message = "Giá trị phải từ 100.0 đến 10,000.0")
    @DecimalMax(value = "10000.0", message = "Giá trị phải từ 100.0 đến 10,000.0")
    private Double ticketPrice;

    private MultipartFile image;

    public FlightDTO() {
    }

    public FlightDTO(String flightNumber, String destination, Double ticketPrice, MultipartFile image) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        this.image = image;
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

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
