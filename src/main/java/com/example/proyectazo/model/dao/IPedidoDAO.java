package com.example.proyectazo.model.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.proyectazo.model.entity.Pedido;

public interface IPedidoDAO extends CrudRepository<Pedido, Long> {

    @Query(value = "select MAX(id_pedido) FROM pedidos;", nativeQuery = true)
    public Long findMaxId();
}
