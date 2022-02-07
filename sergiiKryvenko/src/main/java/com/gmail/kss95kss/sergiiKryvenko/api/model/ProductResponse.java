package com.gmail.kss95kss.sergiiKryvenko.api.model;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;

import java.util.List;

public class ProductResponse {

    private List<Product> productList;

    public ProductResponse() {
    }

    public ProductResponse(List<Product> productList) {
        this.productList = productList;

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "productList=" + productList +
                '}';
    }
}
