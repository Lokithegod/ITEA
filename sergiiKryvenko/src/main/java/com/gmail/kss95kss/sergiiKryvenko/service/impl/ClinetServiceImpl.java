package com.gmail.kss95kss.sergiiKryvenko.service.impl;

import com.gmail.kss95kss.sergiiKryvenko.repository.ClientRepository;
import com.gmail.kss95kss.sergiiKryvenko.repository.model.Client;
import com.gmail.kss95kss.sergiiKryvenko.service.ClientService;
import org.springframework.stereotype.Service;


import javax.websocket.Session;
import java.util.List;
@Service
public class ClinetServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClinetServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> logIn(Integer login) {
        return clientRepository.getByLogin(login);
    }

    @Override
    public void logOut() {

    }
}
