package com.example.proyectazo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectazo.model.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {
}
