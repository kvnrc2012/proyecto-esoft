package com.example.proyectazo.model.dao;

import com.example.proyectazo.model.entity.Proveedor;

import org.springframework.data.repository.CrudRepository;


public interface IProveedorDAO extends CrudRepository<Proveedor,Long> {
    
}
