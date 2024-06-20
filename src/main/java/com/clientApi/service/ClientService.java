package com.clientApi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientApi.model.Client;
import com.clientApi.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }
    
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
    
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}