package com.nsv.jsmbaba.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodByeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext - Shared
        String servletContextInitParam = getServletContext().getInitParameter("email");
        //ServletConfig - Specific to servlet
        String specificemail = getServletConfig().getInitParameter("specificemail");
        PrintWriter writer = resp.getWriter();
        writer.println("GoodBye EasyPay App. servletContextInitParam=" + servletContextInitParam + "\n" + "specificemail=" + specificemail);
    }
}
