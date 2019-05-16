package com.nsv.jsmbaba.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        System.out.println("LoginServlet-userName="+userName+";password="+password);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("received username="+userName+";password="+password);

        if(password.equals("baba")){
            //Session Management Using Cookie
            Cookie cookie = new Cookie("uname",req.getParameter("userName"));
            resp.addCookie(cookie);

            //Session Management Using HttpSession
            HttpSession session = req.getSession(); //Get a new Session
            session.setAttribute("uname",userName);

            writer.println("login successful. Welcome to customer registration page.");
            req.getRequestDispatcher("/registration.html").forward(req,resp);
        }else{
            writer.println("Please check the username and password");
            req.getRequestDispatcher("/login.html").include(req,resp);
        }


    }
}
