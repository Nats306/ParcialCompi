package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.DTO.PrivateJetDTO;
import com.example.parcialcompiladores.modelos.PrivateJet;
import com.example.parcialcompiladores.service.IServicePrivateJet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jets")
public class ControladorPrivateJet {
    @Autowired
    private IServicePrivateJet servicePrivateJet;

    @GetMapping("/{id}")
    public Optional<PrivateJetDTO> buscar(@PathVariable String id) {
        return this.servicePrivateJet.getJetById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody PrivateJetDTO jet) {
        this.servicePrivateJet.addJet(jet);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody PrivateJetDTO jet) {
        this.servicePrivateJet.updateJet(id,jet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.servicePrivateJet.deleteJetById(id);
    }
}