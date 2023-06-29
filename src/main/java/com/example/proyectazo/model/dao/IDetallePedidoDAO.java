package com.example.proyectazo.model.dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.proyectazo.model.entity.DetallePedido;

public interface IDetallePedidoDAO extends CrudRepository<DetallePedido,Long> {
    
    public DetallePedido findByPedido(Long id);
}
