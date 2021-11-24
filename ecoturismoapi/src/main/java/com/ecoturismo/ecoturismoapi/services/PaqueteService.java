package com.ecoturismo.ecoturismoapi.services;

import java.util.List;
import java.util.Optional;

import com.ecoturismo.ecoturismoapi.models.Paquete;
import com.ecoturismo.ecoturismoapi.repositories.PaqueteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaqueteService {
    
    private PaqueteRepository _paqueteRepository;

    @Autowired
    public PaqueteService(PaqueteRepository paqueteRepository){
        this._paqueteRepository = paqueteRepository;
    }

    public void save(Paquete paquete){
        this._paqueteRepository.save(paquete);
    }

    public List<Paquete> findAll(){
        return this._paqueteRepository.findAll();
    }

    public Optional<Paquete> findById(String id){
        return this._paqueteRepository.findById(id);
    }

    public void deleteById(String id){
        this._paqueteRepository.deleteById(id);
    }

    public Boolean existById(String id){
        return this._paqueteRepository.existsById(id);
    }

}
