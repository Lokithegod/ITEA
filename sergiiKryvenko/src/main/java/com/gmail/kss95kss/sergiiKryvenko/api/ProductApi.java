package com.gmail.kss95kss.sergiiKryvenko.api;

import com.gmail.kss95kss.sergiiKryvenko.api.model.ProductResponse;
import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import com.gmail.kss95kss.sergiiKryvenko.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductApi {

    private final ProductService productService ;


    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/getall")
    //public ResponseEntity<ProductResponse> getProduct(@RequestParam(value = "category", required = false)String category, Model model)
    public String getProduct(@RequestParam(value = "category", required = false)String category, Model model)
    {
        List<Product> productList = new ArrayList();
        if (category==null){
            productList.addAll(productService.findAll());
        }else
        {
            productList.addAll(productService.findByCategory(category));
        }
        model.addAttribute("productList",productList);
        return  "product/list_products";
        //return  ResponseEntity.ok().body(new ProductResponse(productList));
    }


//    @PostMapping
//    public List<Product> setProduct()
//    {
//        return "";
//    }


}
