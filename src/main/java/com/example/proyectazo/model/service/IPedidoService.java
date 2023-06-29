package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.proyectazo.model.entity.Pedido;

public interface IPedidoService  {
    public void guardarPedido(Pedido pedido);

    public void eliminarPedido(long id);

    public Pedido buscarPedido(Long id);

    public List<Pedido> cargarPedidos();

    public Long buscarMaximo();

     Page<Pedido> getAll(Pageable pageable);
}
