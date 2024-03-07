package com.utxj.apicontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.utxj.apicontrol.models.Administrativos;
import com.utxj.apicontrol.service.AdministrativosService;

@RestController
@RequestMapping("/api/administrativos")
public class AdministrativosController {

    @Autowired
    private AdministrativosService administrativosService;

    // Obtener todos los administrativos
    @GetMapping
    public ResponseEntity<List<Administrativos>> getAllAdministrativos() {
        List<Administrativos> administrativos = administrativosService.getAllAdministrativos();
        return new ResponseEntity<>(administrativos, HttpStatus.OK);
    }

    // Obtener administrativo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Administrativos> getAdministrativoById(@PathVariable Long id) {
        Optional<Administrativos> administrativo = administrativosService.getAdministrativoById(id);
        return administrativo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Insertar un nuevo administrativo
    @PostMapping
    public ResponseEntity<Administrativos> saveAdministrativo(@RequestBody Administrativos administrativo) {
        Administrativos savedAdministrativo = administrativosService.saveAdministrativo(administrativo);
        return new ResponseEntity<>(savedAdministrativo, HttpStatus.CREATED);
    }

    // Actualizar administrativo por ID
    @PutMapping("/{id}")
    public ResponseEntity<Administrativos> updateAdministrativo(@PathVariable Long id, @RequestBody Administrativos newAdministrativo) {
        Administrativos updatedAdministrativo = administrativosService.updateAdministrativo(id, newAdministrativo);
        return new ResponseEntity<>(updatedAdministrativo, HttpStatus.OK);
    }

    // Eliminar administrativo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrativo(@PathVariable Long id) {
        administrativosService.deleteAdministrativo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
