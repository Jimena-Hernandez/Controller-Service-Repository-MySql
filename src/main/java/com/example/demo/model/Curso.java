package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Curso {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String fecha;
    private String hora;
    private String maestro;

    
    public Curso() {
    }

    
    public Curso(Long id, String name, String fecha, String hora, String maestro) {
        this.id = id;
        this.name = name;
        this.fecha = fecha;
        this.hora = hora;
        this.maestro = maestro;
    }

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }


    public String getMaestro() {
        return maestro;
    }


    public void setMaestro(String maestro) {
        this.maestro = maestro;
    }

    
}