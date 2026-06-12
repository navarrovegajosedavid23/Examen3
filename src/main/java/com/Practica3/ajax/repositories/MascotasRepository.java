package com.Practica3.ajax.repositories;

import com.Practica3.ajax.entities.MascotasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotasRepository extends JpaRepository<MascotasEntity, Long> {
}