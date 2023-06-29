package com.example.proyectazo.model.dao;

import com.example.proyectazo.model.entity.Categoria;

import org.springframework.data.repository.CrudRepository;

public  interface ICategoriaDAO extends CrudRepository<Categoria,Long>{
    
}
