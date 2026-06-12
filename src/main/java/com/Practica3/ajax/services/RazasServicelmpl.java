package com.Practica3.ajax.services;

import com.Practica3.ajax.entities.RazasEntity;
import com.Practica3.ajax.repositories.RazasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RazasServicelmpl implements RazasService {

    @Autowired
    private RazasRepository razasRepository;

    @Override
    public List<RazasEntity> listado() {
        return razasRepository.findAll();
    }

    @Override
    public Optional<RazasEntity> razaPorId(Long id) {
        return razasRepository.findById(id);
    }

    @Override
    public RazasEntity agregarRaza(RazasEntity raza) {
        return razasRepository.save(raza);
    }

    @Override
    public RazasEntity actualizarRaza(Long id, RazasEntity raza) {
        raza.setId(id);
        return razasRepository.save(raza);
    }

    @Override
    public void eliminarRaza(Long id) {
        razasRepository.deleteById(id);
    }
}