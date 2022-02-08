package com.gmail.kss95kss.sergiiKryvenko.repository;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Product,Integer> {
}
