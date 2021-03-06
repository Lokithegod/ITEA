package com.gmail.kss95kss.controller;


import com.gmail.kss95kss.dto.model.Client;
import com.gmail.kss95kss.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LoginController extends HttpServlet {



    private LoginService loginService = new LoginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/login-form.jsp");
        rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login= req.getParameter("login");
        String password= req.getParameter("pass");

        System.out.println("Welcome to login controller. Login : " + login + "  password : "+password);

        Client client = loginService.getClientByLogin(login);
        System.out.println("DB search. Login : " + client.getLogin() + "  password : "+client.getPassword());
        if (Objects.equals(login,client.getLogin())&& Objects.equals(password,client.getPassword()))
        {
            HttpSession session = req.getSession();
            req.setAttribute("validate" ,"TRUE");
            RequestDispatcher rd = req.getRequestDispatcher("./product");
            //System.out.println("to ./product");
            //rd.forward(req,resp);
            req.setAttribute("message","Welcome : "+client.getLogin()+ " !");
            session.setAttribute("user_name",client.getLogin());
            doGet(req,resp);
        }else{
            req.setAttribute("message","wrong login or password");
            doGet(req,resp);
        }
    }
}

