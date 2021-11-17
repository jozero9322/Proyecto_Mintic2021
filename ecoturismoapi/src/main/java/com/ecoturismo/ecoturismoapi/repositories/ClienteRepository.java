package com.ecoturismo.ecoturismoapi.repositories;

import java.util.Optional;

import com.ecoturismo.ecoturismoapi.models.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
    
    public Optional<Cliente> findByCedula(String cedula);

}
