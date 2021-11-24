package com.ecoturismo.ecoturismoapi.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Clientes")
public class Cliente {
    
    private String id; 
    private String cedula;
    private String nombre;
    private String usuario;
    private String password;
    private String rol;
    private String token;

    public Cliente(String id, String cedula, String nombre, String usuario, String password){
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public Cliente(){

    }

    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
