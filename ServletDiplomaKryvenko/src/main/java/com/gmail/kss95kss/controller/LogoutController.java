package com.gmail.kss95kss.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (!session.isNew()) {
            session.invalidate();
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/login-form.jsp");
            rd.forward(req,resp);
            // session = req.getSession();
    }


    }

}
