package com.gmail.kss95kss.sergiiKryvenko.repository;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT p.* FROM product_to_category ptc JOIN products p ON ptc.product_id=p.id JOIN categories c ON ptc.category_id=c.id WHERE c.name = :category", nativeQuery = true)
    List<Product> findByCategory (@Param(value = "category") String category);




}
