package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.DTO.FlightDTO;
import com.example.parcialcompiladores.service.IServiceFlights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")

public class ControladorFlight {
    @Autowired
    private IServiceFlights serviceFlights;

    @GetMapping("/{id}")
    public Optional<FlightDTO> buscar(@PathVariable String id) {
        return this.serviceFlights.getFlightByID(id);
    }

    @PostMapping("/")
    public void add(@RequestBody FlightDTO flight) {
        this.serviceFlights.addFlight(flight);
    }

    @PutMapping("/suspicious")
    public List<FlightDTO> getSuspiciousFlights() {
        return this.serviceFlights.getFlightSuspicius();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.serviceFlights.cancelFlight(id);
    }
}
