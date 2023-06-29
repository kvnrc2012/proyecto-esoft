package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.proyectazo.model.entity.Categoria;

public interface ICategoriaService {
    public void guardarCategoria(Categoria categoria);
    public List<Categoria> cargarCategorias();
    public Categoria buscarCategoria(Long id);
    public void eliminarCategoria(Long id);
    Page<Categoria> getAll(Pageable pageable);
}
