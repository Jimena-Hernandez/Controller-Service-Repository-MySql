package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;

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
@RequestMapping ("/cursos")
public class CursoController {


    private final CursoService service;

public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        Optional<Curso> curso = service.findById(id);
        if (curso.isEmpty()) {
             ResponseEntity.notFound().build();
        } 
            return ResponseEntity.ok(curso.get());
        
    }

    
    @PostMapping 
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        Curso newCurso = service.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso) {
        Optional<Curso> curso1 = service.update(id, curso);

        if (curso1.isPresent()) {
            return ResponseEntity.ok(curso1.get());
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        } 
            return ResponseEntity.noContent().build();
    }
    
    

}
