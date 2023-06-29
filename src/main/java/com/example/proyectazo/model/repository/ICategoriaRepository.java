package com.example.proyectazo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectazo.model.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {
    
}
