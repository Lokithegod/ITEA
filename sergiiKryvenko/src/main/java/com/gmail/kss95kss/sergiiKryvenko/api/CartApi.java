package com.gmail.kss95kss.sergiiKryvenko.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cart")
public class CartApi {

    @GetMapping
    public String getProduct()
    {

        return "cart/getAll";

    }

    public String addToCart()
    {

        return "cart/add";
    }



}
