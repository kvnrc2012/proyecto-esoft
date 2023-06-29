package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectazo.model.dao.IDetallePedidoDAO;
import com.example.proyectazo.model.entity.DetallePedido;

@Service
public class DetallePedidoServiceImp implements IDetallePedidoService {
    @Autowired
    private IDetallePedidoDAO detallePedidoDAO;

    @Override
    public void guardarDetallePedido(DetallePedido detallePedido) {
        detallePedidoDAO.save(detallePedido);
        
    }

    @Override
    public List<DetallePedido> cargarDetallePedidos() {
       return (List<DetallePedido>) detallePedidoDAO.findAll();
    }

    @Override
    public DetallePedido buscarDetallePedido(Long id) {
        return detallePedidoDAO.findByPedido(id);
    }

   

    


    
}
