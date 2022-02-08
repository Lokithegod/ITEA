package com.gmail.kss95kss.sergiiKryvenko.repository;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    @Query(value = "SELECT c.* FROM client c WHERE c.login = :login", nativeQuery = true)
    List<Client> getByLogin (Integer login);
    @Query(value = "INSERT INTO client (id, name, second_name, login, password, email, role) VALUES (NULL,:name , :secondName,:login,:password,:email, NULL)", nativeQuery = true)
    String addClient (String name, String secondName, String password, String email, Integer role);
}
