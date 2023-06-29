package com.example.proyectazo.model.service;

import java.util.List;


import com.example.proyectazo.model.entity.DetallePedido;

public interface IDetallePedidoService  {
    public void guardarDetallePedido(DetallePedido detallePedido);
    public DetallePedido buscarDetallePedido(Long id);
    public List<DetallePedido> cargarDetallePedidos();
    
   
}
