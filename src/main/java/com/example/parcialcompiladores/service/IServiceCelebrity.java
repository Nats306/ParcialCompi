package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.Celebrity;

public interface IServiceCelebrity {
    public void addCelebrity(Celebrity celebrity);
    public Celebrity getCelebrityById(String id);
    public void updateCelebrity(String id, Celebrity celebrity);
    public void deleteCelebrityById(String id);
}
