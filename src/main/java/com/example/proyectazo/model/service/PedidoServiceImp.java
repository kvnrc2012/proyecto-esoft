package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.proyectazo.model.dao.IPedidoDAO;
import com.example.proyectazo.model.entity.Pedido;
import com.example.proyectazo.model.repository.IPedidoRepository;

@Service
public class PedidoServiceImp implements IPedidoService {

    @Autowired
    private IPedidoDAO pedidoDAO;

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> cargarPedidos() {
        return (List<Pedido>) pedidoDAO.findAll();
    }
    
    @Override
    public void guardarPedido(Pedido pedido) {
        pedidoDAO.save(pedido);
    }

    @Override
    public void eliminarPedido(long id) {
        pedidoDAO.deleteById(id);
    }

    @Override
    public Pedido buscarPedido(Long id) {
        return pedidoDAO.findById(id).orElse(null);
    }

    @Override
    public Long buscarMaximo() {
        return  pedidoDAO.findMaxId();
    }

    @Override
    public Page<Pedido> getAll(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }
    
    
}
