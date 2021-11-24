package com.ecotur.ecoturapi.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotur.ecoturapi.exeptions.CustomExeption;
import com.ecotur.ecoturapi.models.Cliente;
import com.ecotur.ecoturapi.services.ClienteService;
import com.ecotur.ecoturapi.utils.Autorizacion;
import com.ecotur.ecoturapi.utils.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


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

    @PostMapping("/clientes/login")
    ResponseEntity<Cliente> login(@RequestBody Cliente cliente){
        Cliente u = this._clienteService.findByCedula(cliente.getCedula());
        if (u.getCedula() == null){
            throw new CustomExeption("Usuario o Contraseña es incorrecta");
        }
        if(!BCrypt.checkpw(cliente.getPassword(), u.getPassword())){
            throw new CustomExeption("Usuario o Contraseña- es incorrecta");
        }

        String token = "";
        Long tiempo = System.currentTimeMillis();

        if (u.getId() != ""){
            token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, Autorizacion.key)
                .setSubject(u.getNombre())
                .setIssuedAt(new Date(tiempo))
                .setExpiration(new Date(tiempo + 900000))
                .claim("cedula", u.getCedula())
                .claim("rol", u.getRol())
                .compact();
        }

        u.setToken(token);
        //this._clienteService.save(cliente);
        //Map<String, String> response = new HashMap<>();
        //response.put("mensaje", "El cliente se ha registrado con exito");
        return ResponseEntity.ok(u);
    }
}

