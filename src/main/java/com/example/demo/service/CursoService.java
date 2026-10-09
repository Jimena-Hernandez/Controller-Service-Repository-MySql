package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.repository.CursoRepository;
import com.example.demo.model.Curso;

@Service 
public class CursoService {

    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo = repo;
    }

    public List<Curso> findAll() {
        return repo.findAll();
    }

    public Optional<Curso> findById(Long id){
        return repo.findById(id);
    }

    public Curso save(Curso curso) {
        return repo.save(curso);
    }

    public Optional<Curso> update(Long id, Curso curso) {
        Optional<Curso> optionalCurso = repo.findById(id);
        if (optionalCurso.isEmpty()) {
            return Optional.empty();
        }
        Curso cursoBd = optionalCurso.get();
        cursoBd.setName(curso.getName());
        cursoBd.setFecha(curso.getFecha());
        cursoBd.setHora(curso.getHora());
        cursoBd.setMaestro(curso.getMaestro());
        return Optional.of(repo.save(cursoBd));
    }

    public boolean delete(long id) {
       
        if (!repo.existsById(id)) {
            return false;
         
        }
        repo.deleteById(id);
        return true;
    }

}
