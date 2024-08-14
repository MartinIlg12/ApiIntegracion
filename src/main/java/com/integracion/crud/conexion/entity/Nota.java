package com.integracion.crud.conexion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_maestro", referencedColumnName = "id")
    private Maestro maestro;

    private double nota;
    private Date fecha;
}
