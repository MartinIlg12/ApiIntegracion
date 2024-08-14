package com.integracion.crud.conexion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;
    private String grado;

    @Column(name = "usuario_id", insertable = false, updatable = false)
    private Long usuarioId;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
}
