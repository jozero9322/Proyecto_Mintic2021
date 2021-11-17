/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sala2.g21.ecoturismoapi.servicios;

import co.sala2.g21.ecoturismoapi.modelos.Cliente;
import co.sala2.g21.ecoturismoapi.modelos.Paquete;
import co.sala2.g21.ecoturismoapi.repositorios.ClienteRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebca
 */
@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Optional<Cliente> getPorDocumento(String documento){
        
        return clienteRepository.findById(documento);
        
    }
    
    public Cliente registrar(Cliente miCliente){
        
        return clienteRepository.save(miCliente);
    }
    
    public Cliente validar(String usuario, String password){
        return clienteRepository.validar(usuario, password);
    } 
    
     public ArrayList<Cliente> getTodos(){
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }
    
}
