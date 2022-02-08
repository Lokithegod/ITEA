package com.gmail.kss95kss.sergiiKryvenko.service;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;

import java.util.List;
import java.util.Map;

public interface CartService {


    public Map<Product,Integer> findAll();
    public Map<Product,Integer> deleteAll();

}
