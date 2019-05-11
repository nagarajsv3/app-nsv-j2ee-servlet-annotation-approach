package com.nsv.jsmbaba.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        System.out.println("userName="+userName+";password="+password);

        PrintWriter writer = resp.getWriter();
        //writer.println("received username="+userName+";password="+password);

        if(password.equals("baba")){
            req.getRequestDispatcher("/registration.html").forward(req,resp);
        }else{
            req.getRequestDispatcher("/login.html").include(req,resp);
        }


    }
}
