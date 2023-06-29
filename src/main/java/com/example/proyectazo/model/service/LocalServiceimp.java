package com.example.proyectazo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.proyectazo.model.dao.ILocalDAO;
import com.example.proyectazo.model.entity.Local;
import com.example.proyectazo.model.repository.ILocalRepository;

@Service
public class LocalServiceimp implements ILocalService {
    
    @Autowired
    private ILocalDAO localDAO;

    @Autowired
    private ILocalRepository localRepository;

    @Override
    public void guardarLocales(Local local) {
        localDAO.save(local);
    }

    @Override
    public List<Local> cargarLocales() {
        return (List<Local>) localDAO.findAll();
    }

    @Override
    public Local buscarLocal(Long id) {
        return localDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarLocal(Long id) {
       localDAO.deleteById(id);
    }

    @Override
    public Page<Local> getAll(Pageable pageable) {
        return localRepository.findAll(pageable);
    }

    
}
