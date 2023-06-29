package com.example.proyectazo.model.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.proyectazo.model.entity.Cliente;


public interface IClienteDAO extends CrudRepository<Cliente,Long> {
}
