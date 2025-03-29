package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.AirportDTO;
import com.example.parcialcompiladores.modelos.Airport;
import com.example.parcialcompiladores.repositories.IAirportRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class AirportService implements IServiceAirport {
    @Autowired
    private IAirportRepository airportRepository;

    private AirportDTO ConvertToDTO(Airport airport) {
        return new AirportDTO(
                airport.getId(),
                airport.getName(),
                airport.getLocation(),
                airport.getCapacity(),
                airport.getOwners()
        );
    };
    @Override
    public void addAirport(@Valid AirportDTO airportDTO) {
        Airport airport= new Airport();
        airport.setId(airportDTO.getId());
        airport.setName(airportDTO.getName());
        airport.setLocation(airportDTO.getLocation());
        airport.setCapacity(airportDTO.getCapacity());
        airport.setOwners(airportDTO.getOwners());
        airportRepository.save(airport);

    }

    @Override
    public List<AirportDTO> getAllAirports(){
        return airportRepository.findAll().stream().map(this::ConvertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<AirportDTO> getAirportById(String id){
        return airportRepository.findById(id).map(this::ConvertToDTO);
    }
}
