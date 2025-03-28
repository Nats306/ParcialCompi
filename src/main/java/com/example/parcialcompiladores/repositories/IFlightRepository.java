package com.example.parcialcompiladores.repositories;

import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.modelos.Flight;
import com.example.parcialcompiladores.modelos.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlightRepository extends JpaRepository<Flight, String> {

    List<Flight> findByPurpose(Purpose purpose);
}
