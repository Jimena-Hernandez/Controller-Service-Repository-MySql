package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Maestro;
import com.example.demo.service.MaestroService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController 
@RequestMapping ("/maestros")
public class MaestroController {


    private final MaestroService service;

public MaestroController(MaestroService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Maestro>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maestro> findById(@PathVariable Long id) {
        Optional<Maestro> maestro = service.findById(id);
        if (maestro.isEmpty()) {
             ResponseEntity.notFound().build();
        } 
            return ResponseEntity.ok(maestro.get());
        
    }

    
    @PostMapping 
    public ResponseEntity<Maestro> save(@RequestBody Maestro maestro) {
        Maestro newMaestro = service.save(maestro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMaestro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maestro> update(@PathVariable Long id, @RequestBody Maestro maestro) {
        Optional<Maestro> maestro1 = service.update(id, maestro);

        if (maestro1.isPresent()) {
            return ResponseEntity.ok(maestro1.get());
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Maestro> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        } 
            return ResponseEntity.noContent().build();
    }
    
    

}
