package com.ecoturismo.ecoturismoapi.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Paquetes")
public class Paquete {

    @Id
    private String id;

    @NotEmpty(message = "El campo nombre no puede estar vacio")
    private String nombre;
    private String ubicacion;
    private String precio;
    private String duracion;
    private String salida;

    public Paquete(){

    }

    public Paquete(String nombre, String ubicacion,String precio, String duracion,String salida){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.duracion = duracion;
        this.salida = salida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    

}
   
