package com.example.proyectazo.model.service;

import java.util.List;

import com.example.proyectazo.model.dao.IProveedorDAO;
import com.example.proyectazo.model.entity.Proveedor;
import com.example.proyectazo.model.repository.IProveedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImp implements IProveedorService {
    @Autowired
    private IProveedorDAO proveedorDAO;

    @Autowired
    private IProveedorRepository proveedorRepository;

    @Override
    public void guardarProveedor(Proveedor proveedor) {
        proveedorDAO.save(proveedor);
    }

    @Override
    public List<Proveedor> cargarProveedores() {
        return (List<Proveedor>)proveedorDAO.findAll();
    }

    @Override
    public Proveedor buscarProveedor(Long id) {
        return proveedorDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorDAO.deleteById(id);
    }

    @Override
    public Page<Proveedor> getAll(Pageable pageable) {
        return proveedorRepository.findAll(pageable);
    }
    
}
