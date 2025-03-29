package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.CelebrityDTO;
import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.repositories.ICelebrityRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class CelebrityService implements IServiceCelebrity {
    @Autowired
    private ICelebrityRepository celebrityRepository;

    private CelebrityDTO convertCelebToDTO(Celebrity celebrity) {
        return new CelebrityDTO(celebrity.getId(),
                celebrity.getTipoId(),
                celebrity.getName(),
                celebrity.getProfession(),
                celebrity.getNetWorth(),
                celebrity.isSuspicious()
        );
    }


    @Override
    public void addCelebrity(@Valid CelebrityDTO celebrityDTO) {
        Celebrity celebrity = new Celebrity();
        celebrity.setId(celebrityDTO.getId());
        celebrity.setName(celebrityDTO.getName());
        celebrity.setTipoId(celebrityDTO.getTipoId());
        celebrity.setProfession(celebrityDTO.getProfession());
        celebrity.setNetWorth(celebrityDTO.getNetWorth());
        celebrity.setSuspicious(celebrityDTO.isSuspicious());

        celebrity = celebrityRepository.save(celebrity);

    }

    @Override
    public Optional<CelebrityDTO> getCelebrityById(String id) {
        return celebrityRepository.findById(id).map(this::convertCelebToDTO);
    }

    @Override
    public void updateCelebrity(String id,@Valid CelebrityDTO celebrity) {
        Optional<Celebrity> celebrityEncontrado = celebrityRepository.findById(id);

        if (celebrityEncontrado.isPresent()) {

            celebrityEncontrado.get().setName(celebrity.getName());
            celebrityEncontrado.get().setTipoId(celebrity.getTipoId());
            celebrityEncontrado.get().setProfession(celebrity.getProfession());
            celebrityEncontrado.get().setNetWorth(celebrity.getNetWorth());
            celebrityEncontrado.get().setSuspicious(celebrity.isSuspicious());

            celebrityRepository.save(celebrityEncontrado.get());

        }
    }

    @Override
    public void deleteCelebrityById(String id) {
        celebrityRepository.deleteById(id);
    }
}
