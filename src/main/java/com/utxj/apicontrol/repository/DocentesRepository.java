package com.utxj.apicontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.utxj.apicontrol.projection.DocentesProjection;

import com.utxj.apicontrol.models.Docentes;
import java.util.List;

public interface DocentesRepository extends JpaRepository<Docentes, Long> {

    @Query("SELECT d.no_control as no_control, d.nombre as nombre, d.apellidoPaterno as apellidoPaterno, d.apellidoMaterno as apellidoMaterno FROM Docentes d")
    List<DocentesProjection> findAllProjectedBy();
}
