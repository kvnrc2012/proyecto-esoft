package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.proyectazo.model.entity.Producto;

public interface IProductoService {
    public String guardarProducto(Producto producto);

    public String eliminarProducto(long id);

    public Producto buscarProducto(Long id);

    public List<Producto> cargarProductos();

    public Page<Producto> getAll(Pageable pageable);
}
