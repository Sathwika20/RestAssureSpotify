package com.bridgelazRestAssureSpotify;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class DbTesting {
    Connection connection;

    @Test
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/dbtesting";
        String user = "root";
        String password = "sathWIKA@20";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return connection;
    }



    }







