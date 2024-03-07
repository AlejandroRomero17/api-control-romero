package com.utxj.apicontrol.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbb_docentes")

public class Docentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docenteID;
    
    private Integer no_control;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String area;
    private String departamento;
}
