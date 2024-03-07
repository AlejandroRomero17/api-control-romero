package com.utxj.apicontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utxj.apicontrol.models.Alumnos;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumnos, Long> {
}