package com.gmail.kss95kss.controller;

import com.gmail.kss95kss.dto.model.Product;
import com.gmail.kss95kss.service.ProductService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartController extends HttpServlet {
    private ProductService ps = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int productid = Integer.valueOf(req.getParameter("id"));
        int numberOfProducts = Integer.valueOf(req.getParameter("numberOfProducts"));
        Product product =  ps.getByID(productid);
        HttpSession session = req.getSession();
        PrintWriter writer = resp.getWriter();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart",new HashMap<Product,Integer>());
            session.setAttribute("numberOfProducts",0);
        }
        Map<Product,Integer> productMap =(Map<Product, Integer>) session.getAttribute("cart");
        if (productMap.containsKey(product)) {
            Integer number = productMap.get(product)+ numberOfProducts;
            productMap.put(product,number);
        }else {
            productMap.put(product,numberOfProducts);
        }
        int numberP = (int) session.getAttribute("numberOfProducts");
        session.setAttribute("numberOfProducts",++numberP);
        session.setAttribute("cart", productMap);
        writer.write(" "+numberP);
        //productMap.add(ps.getByID(productid));
        System.out.println("qweqweqwe"+productMap);
    }
}