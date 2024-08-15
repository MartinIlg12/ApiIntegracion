package com.integracion.crud.conexion.controller;

import com.integracion.crud.conexion.entity.Usuario;

public class LoginRequest {
    private String username;
    private String password;
    private Usuario.TipoUsuario tipo;

    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Usuario.TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(Usuario.TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
