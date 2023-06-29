package com.example.proyectazo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectazo.model.entity.DetallePedido;
import com.example.proyectazo.model.service.IDetallePedidoService;

@RestController
public class DetallePedidoREST {

    @Autowired
    private IDetallePedidoService detallePedidoService;

    @GetMapping("/detalle/buscar/{id}")
    public DetallePedido create(@PathVariable(value = "id") Long id) {
        
        //return categoriaService.buscarCategoria(id);
        return detallePedidoService.buscarDetallePedido(id);
    }
}
