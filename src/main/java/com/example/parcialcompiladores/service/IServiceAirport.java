package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.AirportDTO;
import com.example.parcialcompiladores.modelos.Airport;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IServiceAirport {
    public List<AirportDTO> getAllAirports();
    public Optional<AirportDTO> getAirportById(String id);
    public void addAirport(@Valid AirportDTO airport);
}
