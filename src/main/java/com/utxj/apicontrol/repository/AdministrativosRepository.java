package com.utxj.apicontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utxj.apicontrol.models.Administrativos;

@Repository
public interface AdministrativosRepository extends JpaRepository<Administrativos, Long> {
}