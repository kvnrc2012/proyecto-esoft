package com.example.proyectazo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectazo.model.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto,Long> {
    
}
