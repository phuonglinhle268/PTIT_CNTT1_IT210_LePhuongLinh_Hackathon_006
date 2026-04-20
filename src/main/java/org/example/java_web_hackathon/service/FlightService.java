package org.example.java_web_hackathon.service;

import org.example.java_web_hackathon.model.Flight;
import org.example.java_web_hackathon.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repo;

    public List<Flight> getAll(){
        return repo.findAll();
    }

    public void save(Flight f){
        repo.save(f);
    }

    public void update(Flight f){
        repo.update(f);
    }

    public Flight findById(Long id){
        return repo.findById(id);
    }

    public void delete(Long id){
        repo.delete(id);
    }

    public List<Flight> search(String keyword){
        return repo.findAll().stream()
                .filter(f -> f.getFlightNumber().toLowerCase().contains(keyword.toLowerCase())
                        || f.getDestination().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}