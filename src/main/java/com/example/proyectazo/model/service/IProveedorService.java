package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.proyectazo.model.entity.Proveedor;

public interface IProveedorService {
    public void guardarProveedor(Proveedor proveedor);
    public List<Proveedor> cargarProveedores();
    public Proveedor buscarProveedor(Long id);

    public void eliminarProveedor(Long id);

    public Page<Proveedor> getAll(Pageable pageable);
}
