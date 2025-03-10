package com.example.parcialcompiladores.repositories;

import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.modelos.PrivateJet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrivateJetRepository extends JpaRepository<PrivateJet, String> {
}
