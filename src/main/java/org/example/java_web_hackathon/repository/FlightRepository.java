package org.example.java_web_hackathon.repository;

import org.example.java_web_hackathon.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class gFlightRepository {
    List<Flight> list = new ArrayList<>();

    public List<Flight> findAll(){
        return list;
    }

    public void save(Flight f){
        list.add(f);
    }

    public void update(Flight f){
        delete(f.getId());
        list.add(f);
    }

    public Flight findById(Long id){
        return list.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst().orElse(null);
    }
    public void delete(Long id){
        list.removeIf(x -> x.getId().equals(id));
    }
}

















