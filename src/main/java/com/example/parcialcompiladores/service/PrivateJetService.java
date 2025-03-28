package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.modelos.PrivateJet;
import com.example.parcialcompiladores.repositories.IPrivateJetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PrivateJetService implements IServicePrivateJet{
    @Autowired
    private IPrivateJetRepository privateJetRepository;
    @Override
    public void addJet(PrivateJet jet) {
        this.privateJetRepository.save(jet);
    }

    @Override
    public PrivateJet getJetById(String id) {
        return this.privateJetRepository.findById(id).orElse(null);
    }

    @Override
    public void updateJet(String id, PrivateJet Updatedjet) {
        PrivateJet previousJet = this.privateJetRepository.findById(id).orElse(null);
        if(previousJet != null){
            previousJet.setCapacity(Updatedjet.getCapacity());
            previousJet.setModel(Updatedjet.getModel());
            previousJet.setOwner_id(Updatedjet.getOwner_id());
            previousJet.setVuelosAvion(Updatedjet.getVuelosAvion());
        }

        this.privateJetRepository.save(Updatedjet);

    }

    @Override
    public void deleteJetById(String id) {
        this.privateJetRepository.deleteById(id);

    }
}
