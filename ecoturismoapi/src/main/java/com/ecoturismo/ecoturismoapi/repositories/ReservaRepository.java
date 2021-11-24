package com.ecoturismo.ecoturismoapi.repositories;

import com.ecoturismo.ecoturismoapi.models.Reserva;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva, String>{
    


}
