package com.utxj.apicontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utxj.apicontrol.models.Alumnos;
import com.utxj.apicontrol.repository.AlumnosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnosService {

    @Autowired
    private AlumnosRepository alumnosRepository;

    public List<Alumnos> getAllAlumnos() {
        return alumnosRepository.findAll();
    }

    public Optional<Alumnos> getAlumnoById(Long id) {
        return alumnosRepository.findById(id);
    }

    public Alumnos saveAlumno(Alumnos alumno) {
        return alumnosRepository.save(alumno);
    }

    public Alumnos updateAlumno(Long id, Alumnos newAlumno) {
        Optional<Alumnos> optionalAlumno = alumnosRepository.findById(id);
        if (optionalAlumno.isPresent()) {
            Alumnos alumno = optionalAlumno.get();
            alumno.setMatricula(newAlumno.getMatricula());
            alumno.setNombre(newAlumno.getNombre());
            alumno.setApellidoPaterno(newAlumno.getApellidoPaterno());
            alumno.setApellidoMaterno(newAlumno.getApellidoMaterno());
            alumno.setCorreo(newAlumno.getCorreo());
            alumno.setCuatrimestre(newAlumno.getCuatrimestre());
            alumno.setGrupo(newAlumno.getGrupo());
            return alumnosRepository.save(alumno);
        } else {
            return null;
        }
    }

    public void deleteAlumno(Long id) {
        alumnosRepository.deleteById(id);
    }
}
