package com.example.proyectazo.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyectazo.model.entity.Empleado;

public interface IEmpleadoDAO extends CrudRepository<Empleado,Long> {
    
}
