/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sala2.g21.ecoturismoapi.modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sebca
 */

@Entity
@Table(name = "paquetes")
public class Paquete implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "ubicacion")
    private String ubicacion;
    
    @Column(name = "duracion")
    private double duracion;
    
    @Column(name = "horario")
    private String horario;

    @Column(name = "salida")
    private String salida;
    
     @Column(name = "foto")
    private String foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

     public String getUbicacion() {
        return ubicacion;
    }
     
       public int getDuracion() {
        return (int) duracion;
    }
     
      public String getHorario() {
        return horario;
    }
      
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
       public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
     public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
     
       public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    
    
    
    
}
