/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sala2.g21.ecoturismoapi.servicios;

import co.sala2.g21.ecoturismoapi.modelos.Reserva;
import co.sala2.g21.ecoturismoapi.modelos.Paquete;
import co.sala2.g21.ecoturismoapi.repositorios.ReservaRepository;
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
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;
    
    public Optional<Reserva> getPorId(Long id){
        return reservaRepository.findById(id);
    }
    
    public ArrayList<Reserva> getTodos(){
        return (ArrayList<Reserva>) reservaRepository.findAll();
    }
    
    public Reserva crear(Reserva miReserva){
        return reservaRepository.save(miReserva);
    }
    
    public void borrar(long id){
        reservaRepository.deleteById(id);
     
     }
      
    public ArrayList<Reserva> getPorCliente(Long id){
        return reservaRepository.getPorCliente(id);
    }
    
   
    
}
