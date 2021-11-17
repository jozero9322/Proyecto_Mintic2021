package com.ecoturismo.ecoturismoapi.repositories;

import com.ecoturismo.ecoturismoapi.models.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
    
}
