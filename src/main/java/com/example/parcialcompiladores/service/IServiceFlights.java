package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.FlightDTO;
import com.example.parcialcompiladores.modelos.Flight;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IServiceFlights {
    public void addFlight(@Valid FlightDTO flight);
    public Optional<FlightDTO> getFlightByID(String id);
    public List<FlightDTO> getFlightSuspicius();
    public void cancelFlight(String id);

}
