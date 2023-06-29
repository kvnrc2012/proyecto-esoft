package com.example.proyectazo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectazo.model.entity.Local;

public interface ILocalRepository extends JpaRepository<Local,Long> {
    
}
