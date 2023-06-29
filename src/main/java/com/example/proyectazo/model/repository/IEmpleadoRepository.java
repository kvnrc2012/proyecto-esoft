package com.example.proyectazo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectazo.model.entity.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {
    
}
