package com.nsv.jsmbaba.servlets;

import com.nsv.jsmbaba.domain.Customer;
import com.nsv.jsmbaba.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService service = new CustomerService();
        String city= req.getParameter("cityorstate");
        String action = req.getParameter("action");
        List<Customer> customers=null;
        if(action.equals("SearchByCity")){
            customers = service.searchCustomersByCity(city);
        }else{
            customers = service.searchCustomersByState(city);
        }



        StringBuffer buffer = new StringBuffer();
        buffer.append("<table border=1>");
        buffer.append("<tr><td>customerId</td><td>name</td><td>street</td><td>city</td><td>state</td><td>country</td><td>zipcode</td></tr>");
        for (Customer customer: customers) {
            buffer.append("<tr>");
            buffer.append("<td>").append(customer.getCustomerId()).append("</td>");
            buffer.append("<td>").append(customer.getName()).append("</td>");
            buffer.append("<td>").append(customer.getStreet()).append("</td>");
            buffer.append("<td>").append(customer.getCity()).append("</td>");
            buffer.append("<td>").append(customer.getState()).append("</td>");
            buffer.append("<td>").append(customer.getCountry()).append("</td>");
            buffer.append("<td>").append(customer.getZipCode()).append("</td>");
            buffer.append("</tr>");
        }
        buffer.append("</table>");
        resp.getWriter().print(buffer.toString());
    }
}
