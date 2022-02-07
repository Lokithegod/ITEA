package com.gmail.kss95kss.controller;

import com.gmail.kss95kss.service.ProductService;
import com.gmail.kss95kss.service.RegistrationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class RegistrationController extends HttpServlet {

    public RegistrationService registrationService = new RegistrationService();
    public Logger logger = Logger.getLogger(RegistrationController.class.getSimpleName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/registration-view.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login= req.getParameter("login");
        String password= req.getParameter("password");
        String rePassword= req.getParameter("re_password");
        String name= req.getParameter("name");
        String gender= req.getParameter("gender");
        String address= req.getParameter("address");
        String agree= req.getParameter("agree");
        String email= req.getParameter("email");
        logger.info(req.toString());

       String errorText = registrationService.validate(name,login,password,rePassword,email,gender,address,agree);

       if (errorText=="success")
       {
           req.setAttribute("registration_message","succesfuly created");
           req.setAttribute("insert","true");
       }else
       {
           req.setAttribute("registration_message",errorText);

       }
        doGet(req,resp);

    }
}
