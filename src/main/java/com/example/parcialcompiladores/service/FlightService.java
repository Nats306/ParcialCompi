package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.Flight;
import com.example.parcialcompiladores.repositories.IFlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements IServiceFlights{

    private IFlightRepository flightRepository;
    @Override
    public void addFlight(Flight flight) {

        this.flightRepository.save(flight);

    }

    @Override
    public Flight getFlightByID(String id) {
        return this.flightRepository.findById(id).orElse(null);
    }

    @Override
    public List<Flight> getFlightSuspicius() {

        return flightRepository.findByPurpose("Suspicious");
    }

    @Override
    public void cancelFlight(String id) {

        this.flightRepository.deleteById(id);

    }
}
