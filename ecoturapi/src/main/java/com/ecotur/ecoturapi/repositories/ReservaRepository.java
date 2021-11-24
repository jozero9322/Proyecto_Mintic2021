package com.ecotur.ecoturapi.repositories;

import com.ecotur.ecoturapi.models.Reserva;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva, String>{
    


}
