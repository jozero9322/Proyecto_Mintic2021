/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sala2.g21.ecoturismoapi.servicios;

import co.sala2.g21.ecoturismoapi.modelos.Paquete;
import co.sala2.g21.ecoturismoapi.repositorios.PaqueteRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebca
 */
@Service
public class PaqueteService {
    
    @Autowired
    private PaqueteRepository paqueteRepository;
    
    public Optional<Paquete> getPorId(Long id){
        return paqueteRepository.findById(id);
    }
    
    public ArrayList<Paquete> getTodos(){
        return (ArrayList<Paquete>) paqueteRepository.findAll();
    }
    
    public Paquete crear(Paquete miPaquete){
        return paqueteRepository.save(miPaquete);
    }
    
}
