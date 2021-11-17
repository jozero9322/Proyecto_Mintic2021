/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sala2.g21.ecoturismoapi.controladores;

import co.sala2.g21.ecoturismoapi.modelos.Reserva;
import co.sala2.g21.ecoturismoapi.servicios.ReservaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebca
 */
@RestController
@CrossOrigin
@RequestMapping("/reserva")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;
    
    @GetMapping(path = "/todos")
    public ArrayList<Reserva> getTodos(){
        return reservaService.getTodos();
    }
    
    @PostMapping()
    public Reserva registrar(@RequestBody Reserva miReserva){
        
       return reservaService.crear(miReserva);
    }
    
   @DeleteMapping("/borrar/{id}")
 void deleteReserva(@PathVariable Long id) {
    reservaService.borrar(id);
  }

       
    @GetMapping(path = "/cliente/{id}")
    public ArrayList<Reserva> getPorCliente(@PathVariable("id") Long id){
        return reservaService.getPorCliente(id);
    }
    
}
