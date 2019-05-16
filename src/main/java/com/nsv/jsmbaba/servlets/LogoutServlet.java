package com.nsv.jsmbaba.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Invalidate the session
        HttpSession session = req.getSession(false);
        if(session != null){
            System.out.println("LogoutServlet-Invalidating the session");
            session.invalidate();
            System.out.println("LogoutServlet-Forwarding it to login");
            req.getRequestDispatcher("/login.html").forward(req,resp);
        }else{
            System.out.println("LogoutServlet-Forwarding it to registration");
            req.getRequestDispatcher("/registration.html").forward(req,resp);
        }

        //Expire the Cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie:cookies) {
            cookie.setMaxAge(0);
        }

    }
}
