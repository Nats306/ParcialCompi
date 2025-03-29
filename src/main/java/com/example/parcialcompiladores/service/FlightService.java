package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.FlightDTO;
import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.modelos.Flight;
import com.example.parcialcompiladores.modelos.PrivateJet;
import com.example.parcialcompiladores.modelos.Purpose;
import com.example.parcialcompiladores.repositories.ICelebrityRepository;
import com.example.parcialcompiladores.repositories.IFlightRepository;
import com.example.parcialcompiladores.repositories.IPrivateJetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FlightService implements IServiceFlights{
    @Autowired
    private IFlightRepository flightRepository;
    @Autowired
    private IPrivateJetRepository privateJetRepository;
    @Autowired
    private ICelebrityRepository celebrityRepository;

    private FlightDTO convertToFlightDTO(Flight flight) {
        return new FlightDTO(
                flight.getId(),
                flight.getDeparture_airport(),
                flight.getArrival_airport(),
                flight.getDeparture_time(),
                flight.getArrival_time(),
                flight.getCelebrity().getId(),
                flight.getJet().getId(),
                flight.getPurpose()
        );

    }
    @Override
    public void addFlight(@Valid FlightDTO flightDTO) {
        Flight flight = new Flight();
        if (flightDTO.getCelebrityId() == null) {
            throw new IllegalArgumentException("Celebrity ID cannot be null.");
        }

        if (flightDTO.getJetId() == null) {
            throw new IllegalArgumentException("Jet ID cannot be null.");
        }

        Celebrity CelebrityVuelo= celebrityRepository.findById(flightDTO.getCelebrityId()).get();
        PrivateJet privateJet = privateJetRepository.findById(flightDTO.getJetId()).get();

        flight.setCelebrity(CelebrityVuelo);
        flight.setJet(privateJet);
        flight.setPurpose(flightDTO.getPurpose());
        flight.setDeparture_airport(flightDTO.getDepartureAirport());
        flight.setArrival_airport(flightDTO.getArrivalAirport());
        flight.setDeparture_time(flightDTO.getDepartureTime());
        flight.setArrival_time(flightDTO.getArrivalTime());

        flightRepository.save(flight);

    }

    @Override
    public Optional<FlightDTO> getFlightByID(String id) {
        return this.flightRepository.findById(id).map(this::convertToFlightDTO);
    }

    @Override
    public List<FlightDTO> getFlightSuspicious() {

        return flightRepository.findByPurpose(Purpose.Suspicious).
                stream().map(this::convertToFlightDTO).collect(Collectors.toList());
    }

    @Override
    public void cancelFlight(String id) {

        this.flightRepository.deleteById(id);

    }
}
