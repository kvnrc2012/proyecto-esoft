package com.example.proyectazo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectazo.model.entity.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido,Long> {
    
}
