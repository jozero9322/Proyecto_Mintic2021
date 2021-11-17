/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sala2.g21.ecoturismoapi.controladores;

import co.sala2.g21.ecoturismoapi.modelos.Cliente;
import co.sala2.g21.ecoturismoapi.modelos.Paquete;
import co.sala2.g21.ecoturismoapi.servicios.ClienteService;
import co.sala2.g21.ecoturismoapi.servicios.PaqueteService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/paquete")
public class PaqueteController {
    
    @Autowired
    private PaqueteService paqueteService;
    
    
    @GetMapping( path = "/{id}")
    public Optional<Paquete> getPorId(@PathVariable("id") Long id){
        return paqueteService.getPorId(id);
    }
    
    @GetMapping(path = "/todos")
    public ArrayList<Paquete> getTodos(){
        return paqueteService.getTodos();
    }
    
    @PostMapping()
    public Paquete registrar(@RequestBody Paquete miPaquete){
        return paqueteService.crear(miPaquete);
    }
    
}
