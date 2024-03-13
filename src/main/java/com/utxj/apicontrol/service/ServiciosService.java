package com.utxj.apicontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utxj.apicontrol.models.Servicios;
import com.utxj.apicontrol.repository.ServiciosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosService {

    @Autowired
    private ServiciosRepository serviciosRepository;

    public List<Servicios> getAllServicios() {
        return serviciosRepository.findAll();
    }

    public Optional<Servicios> getServicioById(Long id) {
        return serviciosRepository.findById(id);
    }

    public Servicios saveServicio(Servicios servicio) {
        return serviciosRepository.save(servicio);
    }

    public Servicios updateServicio(Long id, Servicios newServicio) {
        Optional<Servicios> optionalServicio = serviciosRepository.findById(id);
        if (optionalServicio.isPresent()) {
            Servicios servicio = optionalServicio.get();
            servicio.setNo_servicio(newServicio.getNo_servicio());
            servicio.setNombre(newServicio.getNombre());
            servicio.setEdificio(newServicio.getEdificio());
            servicio.setEncargado(newServicio.getEncargado());
            servicio.setHorario(newServicio.getHorario());
            return serviciosRepository.save(servicio);
        } else {
            return null;
        }
    }

    public void deleteServicio(Long id) {
        serviciosRepository.deleteById(id);
    }
}
