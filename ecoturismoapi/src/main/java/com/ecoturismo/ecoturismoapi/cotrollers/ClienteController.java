package com.ecoturismo.ecoturismoapi.cotrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecoturismo.ecoturismoapi.models.Cliente;
import com.ecoturismo.ecoturismoapi.services.ClienteService;

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

        this._clienteService.save(cliente);
        Map<String,String> response = new HashMap<>();
        response.put("Mensaje","El cliente se ha registrado correctamente");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        return this._clienteService.findAll();
    }

}
