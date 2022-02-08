package com.gmail.kss95kss.sergiiKryvenko.service;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Client;
import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;

import java.util.List;

public interface ClientService {

    public List<Client> logIn(Integer clientId);
    public void logOut();
}
