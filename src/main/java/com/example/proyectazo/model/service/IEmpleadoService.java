package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.proyectazo.model.entity.Empleado;

public interface IEmpleadoService {
    public void guardarEmpleados(Empleado empleado);
    public List<Empleado> cargaEmpleados();
    public Empleado buscarEmpleado(Long id);

    public void eliminarEmpleado(Long id);

    public Page<Empleado> getAll(Pageable pageable);
}

