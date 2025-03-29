package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.PrivateJetDTO;
import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.modelos.PrivateJet;
import com.example.parcialcompiladores.repositories.ICelebrityRepository;
import com.example.parcialcompiladores.repositories.IPrivateJetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class PrivateJetService implements IServicePrivateJet{
    @Autowired
    private IPrivateJetRepository privateJetRepository;
    @Autowired
    private ICelebrityRepository celebrityRepository;

    private PrivateJetDTO convertToDTO(PrivateJet privateJet) {
        return new PrivateJetDTO(
                privateJet.getId(),
                privateJet.getModel(),
                privateJet.getCapacity(),
                privateJet.getOwner().getId()

        );
    }
    @Override
    public void addJet(@Valid PrivateJetDTO jet) {
        Celebrity owner= celebrityRepository.findById(jet.getOwner_id()).get();
        PrivateJet privateJet = new PrivateJet();
        privateJet.setId(jet.getId());
        privateJet.setModel(jet.getModel());
        privateJet.setCapacity(jet.getCapacity());
        privateJet.setOwner(owner);

        privateJetRepository.save(privateJet);
    }

    @Override
    public Optional<PrivateJetDTO> getJetById(String id) {
        return privateJetRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public void updateJet(String id,@Valid PrivateJetDTO Updatedjet) {
        Optional<PrivateJet> previousJet = this.privateJetRepository.findById(id);
        Celebrity owner= celebrityRepository.findById(Updatedjet.getOwner_id()).get();
        if(previousJet.isPresent()){
           previousJet.get().setModel(Updatedjet.getModel());
           previousJet.get().setCapacity(Updatedjet.getCapacity());
           previousJet.get().setOwner(owner);

        }

        privateJetRepository.save(previousJet.get());

    }

    @Override
    public void deleteJetById(String id) {
        this.privateJetRepository.deleteById(id);

    }
}
