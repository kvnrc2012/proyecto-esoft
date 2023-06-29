package com.example.proyectazo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectazo.model.entity.Material;

public interface IMaterialDAO extends CrudRepository<Material,Long> {
    
}
