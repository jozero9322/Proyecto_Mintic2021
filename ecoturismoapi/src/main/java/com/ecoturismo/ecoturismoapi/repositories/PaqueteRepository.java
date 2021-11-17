package com.ecoturismo.ecoturismoapi.repositories;

import com.ecoturismo.ecoturismoapi.models.Paquete;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends MongoRepository<Paquete,String>{
    
}
