package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.repository.MaestroRepository;
import com.example.demo.model.Maestro;

@Service 
public class MaestroService {

    private final MaestroRepository repo;

    public MaestroService(MaestroRepository repo) {
        this.repo = repo;
    }

    public List<Maestro> findAll() {
        return repo.findAll();
    }

    public Optional<Maestro> findById(Long id){
        return repo.findById(id);
    }

    public Maestro save(Maestro maestro) {
        return repo.save(maestro);
    }

    public Optional<Maestro> update(Long id, Maestro maestro) {
        Optional<Maestro> optionalMaestro = repo.findById(id);
        if (optionalMaestro.isEmpty()) {
            return Optional.empty();
        }
        Maestro maestroBd = optionalMaestro.get();
        maestroBd.setName(maestro.getName());
        maestroBd.setEdad(maestro.getEdad());
        maestroBd.setCurso(maestro.getCurso());
        return Optional.of(repo.save(maestroBd));
    }

    public boolean delete(long id) {
       
        if (!repo.existsById(id)) {
            return false;
         
        }
        repo.deleteById(id);
        return true;
    }

}
