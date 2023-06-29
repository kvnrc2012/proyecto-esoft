package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.proyectazo.model.entity.Local;

public interface ILocalService {
    public void guardarLocales(Local local);
    public List<Local> cargarLocales();
    public Local buscarLocal(Long id);

    public void eliminarLocal(Long id);

    public Page<Local> getAll(Pageable pageable);
}
