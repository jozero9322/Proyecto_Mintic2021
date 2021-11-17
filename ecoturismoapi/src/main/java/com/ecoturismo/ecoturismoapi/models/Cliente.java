package com.ecoturismo.ecoturismoapi.models;

public class Cliente {
    
    private String id; 
    private String cedula;
    private String nombre;
    private String usuario;
    private String password;

    public Cliente(String id, String cedula, String nombre, String usuario, String password){
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }

    public Cliente(){

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
