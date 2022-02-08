package com.gmail.kss95kss.sergiiKryvenko.api;

import com.gmail.kss95kss.sergiiKryvenko.repository.model.Product;
import com.gmail.kss95kss.sergiiKryvenko.service.CartService;
import com.gmail.kss95kss.sergiiKryvenko.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/cart")
public class CartApi {

    private final CartService cartService;


    public CartApi(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping(path = "/getall")
    public String getProductInCart(@RequestParam(value = "clientId", required = false)Integer clientId, Model model)
    {
        List<Product> cartList = new ArrayList();

        cartList.addAll(cartService.findAllClientProducts(clientId));

        model.addAttribute("cartList",cartList);

        return "cart/list_products_in_cart";

    }
    @PostMapping(name = "/add")
    public void addToCart(@RequestParam(value = "clientId" , required = false)Integer clientId,
                            @RequestParam(value = "productId" , required = false)Integer productId,
                            @RequestParam(value = "count" , required = false)Integer count,
                            Model model) {

        cartService.addInCart(clientId,productId,count);
        // Поправить . Не должно быть редиректа
        // productService.findByCategory(null);


       // return "cart/list_products_in_cart";
    }
    @DeleteMapping(name = "/clear")
    public void clearCart(@RequestParam(value = "clientId" , required = false)Integer clientId,Model model)
    {

        cartService.deleteAll(clientId);

        getProductInCart(clientId,model);


        //return "cart/list_products_in_cart";
    }



}
