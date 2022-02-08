package com.gmail.kss95kss.sergiiKryvenko.service;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface CartService {


    public List<Product> findAllClientProducts(Integer clientId);
    public String addInCart(Integer clientId,Integer productId,Integer count);
    public String  deleteAll(Integer clientId);

}
