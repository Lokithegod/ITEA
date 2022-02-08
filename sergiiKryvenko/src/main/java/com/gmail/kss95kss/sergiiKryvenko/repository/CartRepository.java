package com.gmail.kss95kss.sergiiKryvenko.repository;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CartRepository extends JpaRepository<Product,Integer> {


    @Query(value = "SELECT p.* FROM cart ct JOIN products p ON ct.product_id=p.id JOIN client cl ON ct.client_id=cl.id WHERE cl.id = :clientId", nativeQuery = true)
    List<Product> getByIdClient(Integer clientId);

    @Query(value = "INSERT INTO cart (id, client_id, product_id, count) VALUES (NULL, :clientId , :productId, :count)", nativeQuery = true)
    String addProductInCart(Integer clientId, Integer productId, Integer count);

    @Query(value = "DELETE c.* FROM cart c Where client_id = :clientId", nativeQuery = true)
    String cleareCart(Integer clientId);

}
