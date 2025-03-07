package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.modelos.PrivateJet;
import com.example.parcialcompiladores.service.IServiceCelebrity;
import com.example.parcialcompiladores.service.IServicePrivateJet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jets")
public class ControladorPrivateJet {
    @Autowired
    private IServicePrivateJet servicePrivateJet;

    @GetMapping("/{id}")
    public PrivateJet buscar(@PathVariable String id) {
        return this.servicePrivateJet.getJetById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody PrivateJet jet) {
        this.servicePrivateJet.addJet(jet);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody PrivateJet jet) {
        this.servicePrivateJet.updateJet(id,jet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.servicePrivateJet.deleteJetById(id);
    }
}