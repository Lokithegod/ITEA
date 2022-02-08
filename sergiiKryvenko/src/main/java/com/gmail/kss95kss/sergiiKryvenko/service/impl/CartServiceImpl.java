package com.gmail.kss95kss.sergiiKryvenko.service.impl;

import com.gmail.kss95kss.sergiiKryvenko.repository.CartRepository;
import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import com.gmail.kss95kss.sergiiKryvenko.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public List<Product> findAllClientProducts(Integer id) {
        return cartRepository.getByIdClient(id);
    }


    @Override
    public String addInCart(Integer clientId, Integer productId, Integer count) {
        return cartRepository.addProductInCart(clientId,productId,count);
    }

    @Override
    public String deleteAll(Integer clientId) {
        return cartRepository.cleareCart(clientId);
    }
}
