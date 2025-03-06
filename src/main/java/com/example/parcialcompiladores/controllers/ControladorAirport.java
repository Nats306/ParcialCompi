package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.modelos.Airport;
import com.example.parcialcompiladores.service.IServiceAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class ControladorAirport {
    @Autowired
    private IServiceAirport serviceAirport;

    @GetMapping("/")
    public List<Airport> getAllAirports(){
        return this.serviceAirport.getAllAirports();
    }

    @GetMapping("/{id}")
    public Airport buscar(@PathVariable String id) {
        return this.serviceAirport.getAirportById(id);
    }

}

