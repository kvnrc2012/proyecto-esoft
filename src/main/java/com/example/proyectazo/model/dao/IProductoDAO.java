package com.example.proyectazo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectazo.model.entity.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long> {
    
}
