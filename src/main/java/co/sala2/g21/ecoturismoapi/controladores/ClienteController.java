/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sala2.g21.ecoturismoapi.controladores;

import co.sala2.g21.ecoturismoapi.modelos.Cliente;
import co.sala2.g21.ecoturismoapi.modelos.Paquete;
import co.sala2.g21.ecoturismoapi.servicios.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping( path = "/{documento}")
    public Optional<Cliente> getPorDocumento(@PathVariable("documento") String documento){
        return clienteService.getPorDocumento(documento);
    }
    
    @PostMapping(path = "/validar")
    public Cliente validar(@RequestBody Cliente miCliente){
        return clienteService.validar(miCliente.getUsuario(), miCliente.getPassword());
    }
    
      @GetMapping(path = "/todos")
    public ArrayList<Cliente> getTodos(){
        return clienteService.getTodos();
    }
    
    @PostMapping()
    public Cliente registrar(@RequestBody Cliente miCliente){
        return clienteService.registrar(miCliente);
    }
    
}
