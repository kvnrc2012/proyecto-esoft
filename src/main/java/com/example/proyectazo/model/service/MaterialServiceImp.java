package com.example.proyectazo.model.service;

import java.util.List;

import com.example.proyectazo.model.dao.IMaterialDAO;
import com.example.proyectazo.model.entity.Material;
import com.example.proyectazo.model.repository.IMaterialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImp implements IMaterialService {
    
    @Autowired
    private IMaterialDAO materialDAO;

    @Autowired
    private IMaterialRepository materialRepository;

    @Override
    public String guardarMaterial(Material material) {
        String rpta = "";
        try{
            materialDAO.save(material)   ;
            rpta = "Material guardado Exitosamente!";
        } catch (Exception e) {
            rpta = e.getMessage();
        }
        return rpta;
    }

    @Override
    public List<Material> cargarMateriales() {
        return (List<Material>) materialDAO.findAll();
    }

    @Override
    public Material buscarMaterial(Long id) {
        return materialDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarMaterial(Long id) {
        materialDAO.deleteById(id); 
    }

    @Override
    public Page<Material> getAll(Pageable pageable) {
        return materialRepository.findAll(pageable);
    }

}
