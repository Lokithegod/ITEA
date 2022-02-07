package com.gmail.kss95kss.sergiiKryvenko.service;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product>findAll();
    public List<Product>findByCategory(String category);



}
