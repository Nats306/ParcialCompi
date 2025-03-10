package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.Flight;

import java.util.List;

public interface IServiceFlights {
    public void addFlight(Flight flight);
    public Flight getFlightByID(String id);
    public List<Flight> getFlightSuspicius();
    public void cancelFlight(String id);

}
