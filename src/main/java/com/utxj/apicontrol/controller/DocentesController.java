package com.utxj.apicontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.utxj.apicontrol.models.Docentes;
import com.utxj.apicontrol.service.DocentesService;
import com.utxj.apicontrol.projection.DocentesProjection;

@RestController
@RequestMapping("/api/docentes")
public class DocentesController {

    @Autowired
    private DocentesService docentesService;

    @GetMapping
    public ResponseEntity<List<DocentesProjection>> getAllDocentes() {
        List<DocentesProjection> docentes = docentesService.getAllDocentes();
        return new ResponseEntity<>(docentes, HttpStatus.OK);
    }

    // Obtener docente por ID (mostrando solo algunos campos)
    @GetMapping("/{id}")
    public ResponseEntity<Docentes> getDocenteById(@PathVariable Long id) {
        Optional<Docentes> docente = docentesService.getDocenteById(id);
        return docente.map(value -> {
            Docentes simplifiedDocente = new Docentes();
            simplifiedDocente.setNo_control(value.getNo_control());
            simplifiedDocente.setNombre(value.getNombre());
            simplifiedDocente.setApellidoPaterno(value.getApellidoPaterno());
            simplifiedDocente.setApellidoMaterno(value.getApellidoMaterno());
            return new ResponseEntity<>(simplifiedDocente, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Insertar un nuevo docente
    @PostMapping
    public ResponseEntity<Docentes> saveDocente(@RequestBody Docentes docente) {
        Docentes savedDocente = docentesService.saveDocente(docente);
        return new ResponseEntity<>(savedDocente, HttpStatus.CREATED);
    }

    // Actualizar docente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Docentes> updateDocente(@PathVariable Long id, @RequestBody Docentes newDocente) {
        Docentes updatedDocente = docentesService.updateDocente(id, newDocente);
        return new ResponseEntity<>(updatedDocente, HttpStatus.OK);
    }

    // Eliminar docente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable Long id) {
        docentesService.deleteDocente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
