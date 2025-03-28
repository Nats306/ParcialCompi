package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.repositories.ICelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CelebrityService implements IServiceCelebrity {
    @Autowired
    private ICelebrityRepository celebrityRepository;

    @Override
    public void addCelebrity(Celebrity celebrity) {
        this.celebrityRepository.save(celebrity);
    }
    @Override
    public Celebrity getCelebrityById(String id){
        return this.celebrityRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCelebrity(String id, Celebrity updatedCelebrity){
        Celebrity previousCelebrity = this.celebrityRepository.findById(id).orElse(null);
        if(previousCelebrity != null){
            previousCelebrity.setName(updatedCelebrity.getName());
            previousCelebrity.setProfession(updatedCelebrity.getProfession());
            previousCelebrity.setNetWorth(updatedCelebrity.getNetWorth());
            previousCelebrity.setSuspicious(updatedCelebrity.isSuspicious());
        }

        this.celebrityRepository.save(previousCelebrity);
    }

    @Override
    public void deleteCelebrityById(String id) {
        this.celebrityRepository.deleteById(id);
    }
}
