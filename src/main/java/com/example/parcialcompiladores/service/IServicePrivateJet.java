package com.example.parcialcompiladores.service;
import com.example.parcialcompiladores.DTO.PrivateJetDTO;
import com.example.parcialcompiladores.modelos.PrivateJet;
import jakarta.validation.Valid;

import java.util.Optional;

public interface IServicePrivateJet {
    public void addJet(@Valid PrivateJetDTO jetDTO);
    public Optional<PrivateJetDTO> getJetById(String id);
    public void updateJet(String id,@Valid PrivateJetDTO jetDTO);
    public void deleteJetById(String id);
}
