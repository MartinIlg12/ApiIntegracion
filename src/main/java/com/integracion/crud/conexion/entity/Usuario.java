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


    private TipoUsuario tipo;


    public enum TipoUsuario {
        MAESTRO, ESTUDIANTE
    }
}
