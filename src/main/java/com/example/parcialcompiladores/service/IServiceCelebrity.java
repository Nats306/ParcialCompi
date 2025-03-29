package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.CelebrityDTO;
import jakarta.validation.Valid;

import java.util.Optional;

public interface IServiceCelebrity {
    public void addCelebrity(@Valid CelebrityDTO celebrityDTO);
    public Optional<CelebrityDTO> getCelebrityById(String id);
    public void updateCelebrity(String id, @Valid CelebrityDTO celebrityDTO);
    public void deleteCelebrityById(String id);
}
