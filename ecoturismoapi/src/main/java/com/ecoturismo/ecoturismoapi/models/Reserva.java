package com.ecoturismo.ecoturismoapi.models;

public class Reserva {
    private String id;
    private String personas;
    private String niños;
    private String total;
    private Cliente Cliente;
    private Paquete Paquete;

    public Reserva(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public String getNiños() {
        return niños;
    }

    public void setNiños(String niños) {
        this.niños = niños;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }

    public Paquete getPaquete() {
        return Paquete;
    }

    public void setPaquete(Paquete paquete) {
        Paquete = paquete;
    }

   
    
}
