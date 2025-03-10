package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.modelos.Flight;
import com.example.parcialcompiladores.service.IServiceFlights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")

public class ControladorFlight {
    @Autowired
    private IServiceFlights serviceFlights;

    @GetMapping("/{id}")
    public Flight buscar(@PathVariable String id) {
        return this.serviceFlights.getFlightByID(id);
    }

    @PostMapping("/")
    public void add(@RequestBody Flight flight) {
        this.serviceFlights.addFlight(flight);
    }

    @PutMapping("/suspicious")
    public List<Flight> getSuspiciousFlights() {
        return this.serviceFlights.getFlightSuspicius();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.serviceFlights.cancelFlight(id);
    }
}
