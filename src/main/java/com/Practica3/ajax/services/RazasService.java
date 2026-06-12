package com.Practica3.ajax.services;

import com.Practica3.ajax.entities.RazasEntity;
import java.util.List;
import java.util.Optional;

public interface RazasService {
    List<RazasEntity> listado();
    Optional<RazasEntity> razaPorId(Long id);
    RazasEntity agregarRaza(RazasEntity raza);
    RazasEntity actualizarRaza(Long id, RazasEntity raza);
    void eliminarRaza(Long id);
}