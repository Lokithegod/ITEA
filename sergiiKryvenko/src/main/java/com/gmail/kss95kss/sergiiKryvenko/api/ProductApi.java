package com.gmail.kss95kss.sergiiKryvenko.api;

import com.gmail.kss95kss.sergiiKryvenko.api.model.ProductResponse;
import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import com.gmail.kss95kss.sergiiKryvenko.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductApi {

    private final ProductService productService ;


    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/product")
    public ResponseEntity<ProductResponse> getProduct(@RequestParam(value = "category", required = false)String category)
    {
        List<Product> productList = new ArrayList();
        if (category==null){
            productList.addAll(productService.findAll());
        }else
        {
            productList.addAll(productService.findByCategory(category));
        }

        return  ResponseEntity.ok().body(new ProductResponse(productList));
    }


//    @PostMapping
//    public List<Product> setProduct()
//    {
//        return "";
//    }


}
