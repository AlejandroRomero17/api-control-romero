package com.utxj.apicontrol.service;

import com.utxj.apicontrol.models.Docentes;
import com.utxj.apicontrol.projection.DocentesProjection;
import com.utxj.apicontrol.repository.DocentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocentesService {

    @Autowired
    private DocentesRepository docentesRepository;

    public List<DocentesProjection> getAllDocentes() {
        return docentesRepository.findAllProjectedBy();
    }

    public Optional<Docentes> getDocenteById(Long id) {
        return docentesRepository.findById(id);
    }

    public Docentes saveDocente(Docentes docente) {
        return docentesRepository.save(docente);
    }

    public Docentes updateDocente(Long id, Docentes newDocente) {
        Optional<Docentes> optionalDocente = docentesRepository.findById(id);
        if (optionalDocente.isPresent()) {
            Docentes docente = optionalDocente.get();
            docente.setNo_control(newDocente.getNo_control());
            docente.setNombre(newDocente.getNombre());
            docente.setApellidoPaterno(newDocente.getApellidoPaterno());
            docente.setApellidoMaterno(newDocente.getApellidoMaterno());
            docente.setCorreo(newDocente.getCorreo());
            docente.setArea(newDocente.getArea());
            docente.setDepartamento(newDocente.getDepartamento());
            return docentesRepository.save(docente);
        } else {
            return null;
        }
    }

    public void deleteDocente(Long id) {
        docentesRepository.deleteById(id);
    }
}
