package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.DTO.AirportDTO;
import com.example.parcialcompiladores.service.IServiceAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class ControladorAirport {
    @Autowired
    private IServiceAirport serviceAirport;

    @GetMapping("/")
    public List<AirportDTO> getAllAirports(){
        return this.serviceAirport.getAllAirports();
    }

    @GetMapping("/{id}")
    public Optional<AirportDTO> buscar(@PathVariable String id) {
        return this.serviceAirport.getAirportById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody AirportDTO airport) {this.serviceAirport.addAirport(airport);}
}

