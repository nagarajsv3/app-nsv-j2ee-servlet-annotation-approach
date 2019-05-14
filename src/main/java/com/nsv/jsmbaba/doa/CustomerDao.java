package com.nsv.jsmbaba.doa;

import com.nsv.jsmbaba.domain.Customer;
import com.nsv.jsmbaba.utililty.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public int createCustomer(Customer customer) {
        System.out.println("CustomerDao:Customer=" + customer.toString());
        Connection connection = JdbcUtility.getMeADatabaseConnection();

        int updatedRows = 0;
        String sql = "insert into customer(name,street,city,state,country,zipcode) values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getStreet());
            preparedStatement.setString(3, customer.getCity());
            preparedStatement.setString(4, customer.getState());
            preparedStatement.setString(5, customer.getCountry());
            preparedStatement.setString(6, customer.getZipCode());

            updatedRows = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }

    public List<Customer> searchCustomersByCity(String city) {
        List<Customer> customers = new ArrayList<>();
        System.out.println("CustomerDao:searchCustomersByCity=" + city);
        Connection connection = JdbcUtility.getMeADatabaseConnection();
        String sql = "select * from customer where city = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customerId"));
                customer.setName(resultSet.getString("name"));
                customer.setStreet(resultSet.getString("street"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setCountry(resultSet.getString("country"));
                customer.setZipCode(resultSet.getString("zipcode"));
                customers.add(customer);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return customers;

    }

    public List<Customer> searchCustomersByState(String state) {
        List<Customer> customers = new ArrayList<>();
        System.out.println("CustomerDao:searchCustomersByState=" + state);
        Connection connection = JdbcUtility.getMeADatabaseConnection();
        String sql = "select * from customer where state = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, state);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customerId"));
                customer.setName(resultSet.getString("name"));
                customer.setStreet(resultSet.getString("street"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setCountry(resultSet.getString("country"));
                customer.setZipCode(resultSet.getString("zipcode"));
                customers.add(customer);
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;

    }
}
