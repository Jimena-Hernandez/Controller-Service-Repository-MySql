package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Maestro;

public interface MaestroRepository  extends JpaRepository<Maestro, Long> {


}