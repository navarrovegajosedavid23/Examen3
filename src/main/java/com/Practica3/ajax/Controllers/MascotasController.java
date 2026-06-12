package com.Practica3.ajax.Controllers;

import com.Practica3.ajax.entities.MascotasEntity;
import com.Practica3.ajax.services.MascotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MascotasController {

    @Autowired
    private MascotasService mascotasService;

    @GetMapping("/mascotas")
    public String mascotas() {
        return "mascotas";
    }

    @GetMapping("/mascotas/api/mascotas")
    @ResponseBody
    public ResponseEntity<List<MascotasEntity>> listadoMascotasAJAX() {
        return ResponseEntity.ok(mascotasService.listado());
    }

    @GetMapping("/mascotas/api/mascotas/{id}")
    @ResponseBody
    public ResponseEntity<Optional<MascotasEntity>> mascotaByIdAJAX(@PathVariable Long id) {
        return ResponseEntity.ok(mascotasService.mascotaPorId(id));
    }

    @PostMapping("/mascotas/api/mascotas")
    @ResponseBody
    public ResponseEntity<MascotasEntity> crearMascotasAJAX(@RequestBody MascotasEntity mascota) {
        return ResponseEntity.ok(mascotasService.agregarMascota(mascota));
    }

    @PatchMapping("/mascotas/api/mascotas/{id}")
    @ResponseBody
    public ResponseEntity<MascotasEntity> actualizarMascotaAJAX(@PathVariable Long id, @RequestBody MascotasEntity mascota) {
        return ResponseEntity.ok(mascotasService.actualizarMascota(id, mascota));
    }

    @DeleteMapping("/mascotas/api/mascotas/{id}")
    @ResponseBody
    public void eliminarMascotaAJAX(@PathVariable Long id) {
        mascotasService.eliminarMascota(id);
    }
}