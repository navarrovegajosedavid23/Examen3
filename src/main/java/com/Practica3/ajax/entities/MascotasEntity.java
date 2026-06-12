package com.Practica3.ajax.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MascotasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;
    private String observaciones;
    private Long raza; // Guardará el ID de la raza seleccionada

    public MascotasEntity() {
    }

    public MascotasEntity(Long id, String nombre, int edad, String observaciones, Long raza) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.observaciones = observaciones;
        this.raza = raza;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getRaza() {
        return raza;
    }

    public void setRaza(Long raza) {
        this.raza = raza;
    }
}