package com.ecotur.ecoturapi.repositories;


import com.ecotur.ecoturapi.models.Paquete;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends MongoRepository<Paquete,String>{
    
}
