package org.example.java_web_hackathon.controller;

import jakarta.validation.Valid;
import org.example.java_web_hackathon.dto.FlightDTO;
import org.example.java_web_hackathon.model.Flight;
import org.example.java_web_hackathon.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService service;

    String uploadDir = "D:\\Java_Web_Hackathon\\src\\main\\webapp\\images";

    @GetMapping
    public String list(
            Model model,
            @RequestParam(name = "keyword", required = false) String keyword
    ){
        if (keyword != null){
            model.addAttribute("flights", service.search(keyword));
        } else {
            model.addAttribute("flights", service.getAll());
        }
        return "list";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("flightDTO", new FlightDTO());
        model.addAttribute("actionURL", "/flights/create");
        return "form";
    }

    @PostMapping("/create")
    public String create(
            @Valid @ModelAttribute("flightDTO") FlightDTO dto,
            BindingResult result
    ) throws Exception {
        if (result.hasErrors()){
            return "form";
        }

        Flight f = new Flight();
        f.setId((long) (service.getAll().size()+1));
        f.setFlightNumber(dto.getFlightNumber());
        f.setDestination(dto.getDestination());
        f.setDepartureTime(LocalDateTime.now());
        f.setTicketPrice(dto.getTicketPrice());

        MultipartFile file = dto.getImage();
        if (file != null && !file.isEmpty()){
            String fileName = file.getOriginalFilename();
            File dest = new File(uploadDir + File.separator + fileName);
            file.transferTo(dest);
            f.setAirlineLogo(fileName);
        }
        service.save(f);
        return "redirect:/flights";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model
    ){
        Flight f = service.findById(id);
        FlightDTO dto = new FlightDTO();
        dto.setFlightNumber(f.getFlightNumber());
        dto.setDestination(f.getDestination());
        dto.setTicketPrice(f.getTicketPrice());

        model.addAttribute("flightDTO",dto);
        model.addAttribute("id", id);
        model.addAttribute("actionURL", "/flights/edit/" + id);
        model.addAttribute("currentImage", f.getAirlineLogo());
        return "form";
    }

    @PostMapping("/edit/{id}")
    public String update(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute FlightDTO dto,
            BindingResult result
    ){
        if (result.hasErrors()){
            return "form";
        }
        Flight f = new Flight();
        f.setId(id);
        f.setFlightNumber(dto.getFlightNumber());
        f.setDestination(dto.getDestination());
        f.setDepartureTime(LocalDateTime.now());
        f.setTicketPrice(dto.getTicketPrice());

        MultipartFile file = dto.getImage();
        if (file != null && !file.isEmpty()){
            try {
                String fileName = file.getOriginalFilename();
                File dest = new File(uploadDir + File.separator + fileName);
                file.transferTo(dest);
                f.setAirlineLogo(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Flight old = service.findById(id);
            f.setAirlineLogo(old.getAirlineLogo());
        }
        service.update(f);
        return "redirect:/flights";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/flights";
    }

}

























