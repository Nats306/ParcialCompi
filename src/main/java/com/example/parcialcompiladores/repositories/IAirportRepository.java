package com.example.parcialcompiladores.repositories;

import com.example.parcialcompiladores.modelos.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirportRepository extends JpaRepository<Airport, String> {
}
