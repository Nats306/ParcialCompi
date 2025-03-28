package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.Airport;
import com.example.parcialcompiladores.repositories.IAirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AirportService implements IServiceAirport {
    @Autowired
    private IAirportRepository airportRepository;

    @Override
    public void addAirport(Airport airport) {
        this.airportRepository.save(airport);
    }

    @Override
    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(String id){
        return airportRepository.findById(id).orElse(null);
    }
}
