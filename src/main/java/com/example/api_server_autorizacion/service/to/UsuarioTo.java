package com.example.api_server_autorizacion.service.to;

import java.io.Serializable;

public class UsuarioTo implements Serializable {

    private static final long serialVersionUID =1L;
    
    private String nombre;
    private String password;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}