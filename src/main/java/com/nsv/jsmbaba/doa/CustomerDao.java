package com.nsv.jsmbaba.doa;

import com.nsv.jsmbaba.domain.Customer;
import com.nsv.jsmbaba.utililty.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDao {

    public int createCustomer(Customer customer){
        System.out.println("CustomerDao:Customer="+customer.toString());
        Connection connection = JdbcUtility.getMeADatabaseConnection();

        int updatedRows=0;
        String sql = "insert into customer(name,street,city,state,country,zipcode) values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getStreet());
            preparedStatement.setString(3,customer.getCity());
            preparedStatement.setString(4,customer.getState());
            preparedStatement.setString(5,customer.getCountry());
            preparedStatement.setString(6,customer.getZipCode());

            updatedRows= preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }

}
