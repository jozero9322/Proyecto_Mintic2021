package com.ecotur.ecoturapi.repositories;


import java.util.Optional;

import com.ecotur.ecoturapi.models.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
    
    public Optional<Cliente> findByCedula(String cedula);

}

