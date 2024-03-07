package com.utxj.apicontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.utxj.apicontrol.models.Servicios;
import com.utxj.apicontrol.service.ServiciosService;

@RestController
@RequestMapping("/api/servicios")
public class ServiciosController {

    @Autowired
    private ServiciosService serviciosService;

    // Obtener todos los servicios
    @GetMapping
    public ResponseEntity<List<Servicios>> getAllServicios() {
        List<Servicios> servicios = serviciosService.getAllServicios();
        return new ResponseEntity<>(servicios, HttpStatus.OK);
    }

    // Obtener servicio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Servicios> getServicioById(@PathVariable Long id) {
        Optional<Servicios> servicio = serviciosService.getServicioById(id);
        return servicio.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Insertar un nuevo servicio
    @PostMapping
    public ResponseEntity<Servicios> saveServicio(@RequestBody Servicios servicio) {
        Servicios savedServicio = serviciosService.saveServicio(servicio);
        return new ResponseEntity<>(savedServicio, HttpStatus.CREATED);
    }

    // Actualizar servicio por ID
    @PutMapping("/{id}")
    public ResponseEntity<Servicios> updateServicio(@PathVariable Long id, @RequestBody Servicios newServicio) {
        Servicios updatedServicio = serviciosService.updateServicio(id, newServicio);
        return new ResponseEntity<>(updatedServicio, HttpStatus.OK);
    }

    // Eliminar servicio por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Long id) {
        serviciosService.deleteServicio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
