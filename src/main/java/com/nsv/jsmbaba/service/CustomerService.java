package com.nsv.jsmbaba.service;

import com.nsv.jsmbaba.doa.CustomerDao;
import com.nsv.jsmbaba.domain.Customer;

public class CustomerService {

    public int createCustomer(Customer customer){
        CustomerDao customerDao = new CustomerDao();
        return customerDao.createCustomer(customer);
    }

}
