package com.ecoturismo.ecoturismoapi.services;

import java.util.List;
import java.util.Optional;

import com.ecoturismo.ecoturismoapi.models.Cliente;
import com.ecoturismo.ecoturismoapi.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    private ClienteRepository _clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this._clienteRepository = clienteRepository;
    }

    public void save(Cliente cliente){
        this._clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return this._clienteRepository.findAll();
    }

    public Optional<Cliente> findById(String id){
        return this._clienteRepository.findById(id);
    }

    public void deleteById(String id){
        this._clienteRepository.deleteById(id);
    }

    public Boolean existById(String id){
        return this._clienteRepository.existsById(id);
    }

}
