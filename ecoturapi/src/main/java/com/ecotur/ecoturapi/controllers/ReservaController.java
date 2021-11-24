package com.ecotur.ecoturapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotur.ecoturapi.models.Reserva;
import com.ecotur.ecoturapi.services.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ReservaController {

    private ReservaService _reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService){
        this._reservaService = reservaService;
    }

    @GetMapping("/reservas")
    public List<Reserva> findAll(){
        return this._reservaService.findAll();
    }

    @PostMapping("/reservas")
    ResponseEntity<Map<String,String>>save(@RequestBody Reserva reserva){

        this._reservaService.save(reserva);
        Map<String,String> response = new HashMap<>();
        response.put("Mensaje","La RESERVA se ha registrado correctamente");
        return ResponseEntity.ok(response);
    }


}
