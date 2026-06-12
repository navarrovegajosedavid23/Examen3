package com.Practica3.ajax.services;

import com.Practica3.ajax.entities.MascotasEntity;
import com.Practica3.ajax.repositories.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotasServicelmpl implements MascotasService {

    @Autowired
    private MascotasRepository mascotasRepository;

    @Override
    public List<MascotasEntity> listado() {
        return mascotasRepository.findAll();
    }

    @Override
    public Optional<MascotasEntity> mascotaPorId(Long id) {
        return mascotasRepository.findById(id);
    }

    @Override
    public MascotasEntity agregarMascota(MascotasEntity mascota) {
        return mascotasRepository.save(mascota);
    }

    @Override
    public MascotasEntity actualizarMascota(Long id, MascotasEntity mascota) {
        mascota.setId(id);
        return mascotasRepository.save(mascota);
    }

    @Override
    public void eliminarMascota(Long id) {
        mascotasRepository.deleteById(id);
    }
}