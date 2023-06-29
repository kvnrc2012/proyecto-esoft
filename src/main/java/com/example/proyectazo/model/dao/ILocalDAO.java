package com.example.proyectazo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectazo.model.entity.Local;

public interface ILocalDAO extends CrudRepository<Local,Long> {
    
}
