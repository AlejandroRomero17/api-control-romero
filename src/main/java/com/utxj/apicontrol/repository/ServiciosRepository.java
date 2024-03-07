package com.utxj.apicontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utxj.apicontrol.models.Servicios;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Long> {
}