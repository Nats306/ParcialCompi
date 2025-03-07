package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.modelos.Celebrity;
import com.example.parcialcompiladores.service.IServiceCelebrity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/celebrities")
public class ControladorCelebrity {
    @Autowired
    private IServiceCelebrity serviceCelebrity;

    @GetMapping("/{id}")
    public Celebrity buscar(@PathVariable String id) {
        return this.serviceCelebrity.getCelebrityById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody Celebrity celebrity) {
        this.serviceCelebrity.addCelebrity(celebrity);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Celebrity celebrity) {
        this.serviceCelebrity.updateCelebrity(id,celebrity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.serviceCelebrity.deleteCelebrityById(id);
    }
}
