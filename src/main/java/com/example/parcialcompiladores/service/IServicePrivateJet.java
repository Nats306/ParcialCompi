package com.example.parcialcompiladores.service;
import com.example.parcialcompiladores.modelos.PrivateJet;

public interface IServicePrivateJet {
    public void addJet(PrivateJet jet);
    public PrivateJet getJetById(String id);
    public void updateJet(String id, PrivateJet jet);
    public void deleteJetById(String id);
}
