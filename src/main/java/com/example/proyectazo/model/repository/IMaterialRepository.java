package com.example.proyectazo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectazo.model.entity.Material;

public interface IMaterialRepository extends JpaRepository<Material,Long> {
    
}
