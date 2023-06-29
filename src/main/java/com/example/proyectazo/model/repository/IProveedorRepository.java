package com.example.proyectazo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectazo.model.entity.Proveedor;

public interface IProveedorRepository extends JpaRepository<Proveedor,Long> {
    
}
