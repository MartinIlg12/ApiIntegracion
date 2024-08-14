package com.integracion.crud.conexion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    @OneToOne(mappedBy = "usuario")
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario")
    private Maestro maestro;

    public enum TipoUsuario {
        MAESTRO, ESTUDIANTE
    }
}
