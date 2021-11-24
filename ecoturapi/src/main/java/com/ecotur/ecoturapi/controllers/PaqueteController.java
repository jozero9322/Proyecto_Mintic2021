package com.ecotur.ecoturapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ecotur.ecoturapi.exeptions.CustomExeption;
import com.ecotur.ecoturapi.models.Paquete;
import com.ecotur.ecoturapi.services.PaqueteService;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.validation.Errors;
// import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class PaqueteController {
    
    private PaqueteService _paqueteService;

    @Autowired
    public PaqueteController(PaqueteService paqueteService){
        this._paqueteService = paqueteService;
    }

    @GetMapping("/paquetes")
    public List<Paquete> findAll(){
        return this._paqueteService.findAll();
    }

    @PostMapping("/paquetes")
    ResponseEntity<Map<String,String>>save(@Valid @RequestBody Paquete paquete, Errors errors){
        if(errors.hasErrors()){
            throwError(errors);
        }
        this._paqueteService.save(paquete);
        Map<String,String> response = new HashMap<>();
        response.put("Mensaje","El paquete se ha registrado correctamente");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/paquetes")
    ResponseEntity<Map<String,String>> update(@RequestBody Paquete paquete){
        this._paqueteService.save(paquete);
        Map<String,String> response = new HashMap<>();
        response.put("mensaje","El Paquete se ha actualizado correctamente");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/paquetes/{id}")
    ResponseEntity<Map<String,String>> delete(@PathVariable String id){
        
        Boolean existenciaPaquete = this._paqueteService.existById(id);
        Map<String,String> response = new HashMap<>();

        if ( !existenciaPaquete ){
            response.put("mensaje","Este paquete no existe en la BD");
            return ResponseEntity.ok(response);
        }
        this._paqueteService.deleteById(id);
        
        response.put("mensaje","El Paquete se ha ELIMINADO correctamente");
        return ResponseEntity.ok(response);
    }

    public void throwError(Errors errors){
        String mensaje = "";
        int index = 0;
        for(ObjectError e:errors.getAllErrors()){
            if(index>0){
                mensaje+=" | ";
            }
            mensaje+=String.format("parametro: %s - Mensaje: %s", e.getObjectName(), e.getDefaultMessage());

        }
        throw new CustomExeption(mensaje);
    }
    
}
