package com.gmail.kss95kss.sergiiKryvenko.service.impl;

import com.gmail.kss95kss.sergiiKryvenko.repository.ClientRepository;
import com.gmail.kss95kss.sergiiKryvenko.service.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final ClientRepository clientRepository;

    public RegistrationServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public void registration(String name, String secondName, String password, String email, Integer role) {

        clientRepository.addClient(name,secondName,password,email,role);


    }
}
