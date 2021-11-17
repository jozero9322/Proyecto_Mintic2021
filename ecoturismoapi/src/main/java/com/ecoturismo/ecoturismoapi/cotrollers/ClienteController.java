package com.ecoturismo.ecoturismoapi.cotrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecoturismo.ecoturismoapi.models.Cliente;
import com.ecoturismo.ecoturismoapi.services.ClienteService;
import com.ecoturismo.ecoturismoapi.utils.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ClienteController {

    private ClienteService _clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService){
        this._clienteService = clienteService;
    }

    @PostMapping("/clientes")
    ResponseEntity<Map<String,String>>save(@RequestBody Cliente cliente){
        cliente.setPassword(BCrypt.hashpw(cliente.getPassword(), BCrypt.gensalt()));
        Cliente u = this._clienteService.findByCedula(cliente.getCedula());

        Map<String,String> response = new HashMap<>();

        if ( u.getId() == null){

            this._clienteService.save(cliente);
            response.put("Mensaje","El cliente se ha registrado correctamente");
            

        } else {
            response.put("Mensaje","Hay un cliente con esta Cédula ya esta registrado");
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        return this._clienteService.findAll();
    }

}
