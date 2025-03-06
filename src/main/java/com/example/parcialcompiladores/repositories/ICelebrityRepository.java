package com.example.parcialcompiladores.repositories;

import com.example.parcialcompiladores.modelos.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICelebrityRepository extends JpaRepository<Celebrity, String> {
}
