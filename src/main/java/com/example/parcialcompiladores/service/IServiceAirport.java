package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.Airport;
import java.util.List;

public interface IServiceAirport {
    public List<Airport> getAllAirports();
    public Airport getAirportById(String id);
    public void addAirport(Airport airport);
}
