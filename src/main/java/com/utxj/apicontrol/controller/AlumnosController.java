package com.utxj.apicontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.utxj.apicontrol.models.Alumnos;
import com.utxj.apicontrol.service.AlumnosService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnosController {

    @Autowired
    private AlumnosService alumnosService;

    // Obtener todos los alumnos
    @GetMapping
    public ResponseEntity<List<Alumnos>> getAllAlumnos() {
        List<Alumnos> alumnos = alumnosService.getAllAlumnos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    // Obtener alumno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Alumnos> getAlumnoById(@PathVariable Long id) {
        Optional<Alumnos> alumno = alumnosService.getAlumnoById(id);
        return alumno.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Insertar un nuevo alumno
    @PostMapping
    public ResponseEntity<Alumnos> saveAlumno(@RequestBody Alumnos alumno) {
        Alumnos savedAlumno = alumnosService.saveAlumno(alumno);
        return new ResponseEntity<>(savedAlumno, HttpStatus.CREATED);
    }

    // Actualizar alumno por ID
    @PutMapping("/{id}")
    public ResponseEntity<Alumnos> updateAlumno(@PathVariable Long id, @RequestBody Alumnos newAlumno) {
        Alumnos updatedAlumno = alumnosService.updateAlumno(id, newAlumno);
        return new ResponseEntity<>(updatedAlumno, HttpStatus.OK);
    }

    // Eliminar alumno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnosService.deleteAlumno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
