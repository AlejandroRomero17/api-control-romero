package com.utxj.apicontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utxj.apicontrol.models.Administrativos;
import com.utxj.apicontrol.repository.AdministrativosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativosService {

    @Autowired
    private AdministrativosRepository administrativosRepository;

    public List<Administrativos> getAllAdministrativos() {
        return administrativosRepository.findAll();
    }

    public Optional<Administrativos> getAdministrativoById(Long id) {
        return administrativosRepository.findById(id);
    }

    public Administrativos saveAdministrativo(Administrativos administrativo) {
        return administrativosRepository.save(administrativo);
    }

    public Administrativos updateAdministrativo(Long id, Administrativos newAdministrativo) {
        Optional<Administrativos> optionalAdministrativo = administrativosRepository.findById(id);
        if (optionalAdministrativo.isPresent()) {
            Administrativos administrativo = optionalAdministrativo.get();
            administrativo.setNo_control(newAdministrativo.getNo_control());
            administrativo.setNombre(newAdministrativo.getNombre());
            administrativo.setApellidoPaterno(newAdministrativo.getApellidoPaterno());
            administrativo.setApellidoMaterno(newAdministrativo.getApellidoMaterno());
            administrativo.setCorreo(newAdministrativo.getCorreo());
            administrativo.setArea(newAdministrativo.getArea());
            administrativo.setDepartamento(newAdministrativo.getDepartamento());
            administrativo.setHorario(newAdministrativo.getHorario());
            return administrativosRepository.save(administrativo);
        } else {
            return null;
        }
    }

    public void deleteAdministrativo(Long id) {
        administrativosRepository.deleteById(id);
    }
}
