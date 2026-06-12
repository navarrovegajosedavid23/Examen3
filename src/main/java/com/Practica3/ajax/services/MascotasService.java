package com.Practica3.ajax.services;

import com.Practica3.ajax.entities.MascotasEntity;
import java.util.List;
import java.util.Optional;

public interface MascotasService {
    List<MascotasEntity> listado();
    Optional<MascotasEntity> mascotaPorId(Long id);
    MascotasEntity agregarMascota(MascotasEntity mascota);
    MascotasEntity actualizarMascota(Long id, MascotasEntity mascota);
    void eliminarMascota(Long id);
}