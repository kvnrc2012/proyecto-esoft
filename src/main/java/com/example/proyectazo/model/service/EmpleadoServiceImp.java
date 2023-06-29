package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.proyectazo.model.dao.IEmpleadoDAO;
import com.example.proyectazo.model.entity.Empleado;
import com.example.proyectazo.model.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {

    @Autowired
    private IEmpleadoDAO empleadoDAO;

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public void guardarEmpleados(Empleado empleado) {
        empleadoDAO.save(empleado);
        
    }

    @Override
    public List<Empleado> cargaEmpleados() {
        return (List<Empleado>) empleadoDAO.findAll();
    }

    @Override
    public Empleado buscarEmpleado(Long id) {
        return empleadoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoDAO.deleteById(id);
        
    }

    @Override
    public Page<Empleado> getAll(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }
    
}
