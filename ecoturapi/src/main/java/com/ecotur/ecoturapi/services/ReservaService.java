package com.ecotur.ecoturapi.services;

import java.util.List;

import com.ecotur.ecoturapi.models.Reserva;
import com.ecotur.ecoturapi.repositories.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    
    private ReservaRepository _reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository){
        this._reservaRepository = reservaRepository;
    }

    public void save(Reserva reserva){
        this._reservaRepository.save(reserva);
    }

    public List<Reserva> findAll(){
        return this._reservaRepository.findAll();
    }

    public Boolean existById(String id) {
        return null;
    }

}
