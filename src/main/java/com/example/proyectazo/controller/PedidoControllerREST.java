package com.example.proyectazo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.example.proyectazo.model.entity.Producto;
//import com.example.proyecto.model.service.ICategoriaService;
import com.example.proyectazo.model.service.IProductoService;

@RestController
public class PedidoControllerREST {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos/buscar/{id}")
    public Producto create(@PathVariable(value = "id") Long id) {
        
        //return categoriaService.buscarCategoria(id);
        return productoService.buscarProducto(id);
    }
}
