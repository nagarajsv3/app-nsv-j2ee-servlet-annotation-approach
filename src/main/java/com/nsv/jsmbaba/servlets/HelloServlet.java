package com.nsv.jsmbaba.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Hello EasyPay App");

        //RequestDispatcher - Dispatches requests from one servlet to another
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/goodbye");

        //include method - includes response from all servlets
        //requestDispatcher.include(req, resp);

        //forward method - kills response from previous servlets
        //requestDispatcher.forward(req,resp);

        //sendRedirect - hard redirect - Generates a brand new request
        resp.sendRedirect("http://www.google.com");
    }
}
