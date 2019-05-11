package com.nsv.jsmbaba.service;

import com.nsv.jsmbaba.doa.CustomerDao;
import com.nsv.jsmbaba.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public int createCustomer(Customer customer){
        CustomerDao customerDao = new CustomerDao();
        return customerDao.createCustomer(customer);
    }

    public List<Customer> searchCustomers(String city) {
        List<Customer> customers = new ArrayList<>();
        CustomerDao customerDao = new CustomerDao();
        customers = customerDao.searchCustomers(city);
        return customers;
    }
}
