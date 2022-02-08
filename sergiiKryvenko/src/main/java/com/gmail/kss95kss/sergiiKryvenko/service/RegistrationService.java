package com.gmail.kss95kss.sergiiKryvenko.service;

import com.gmail.kss95kss.sergiiKryvenko.repository.ClientRepository;

public interface RegistrationService {

    void registration(String name,String secondName,String password,String email,Integer role);
}
