package com.gmail.kss95kss.sergiiKryvenko.service.impl;

import com.gmail.kss95kss.sergiiKryvenko.repository.ProductRepository;
import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import com.gmail.kss95kss.sergiiKryvenko.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategory(String category) {
      return productRepository.findByCategory(category);
    }
}
