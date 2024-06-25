package com.ust.JdbcToutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc2Create {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/JDBC";
            String un = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, un, password);

            Statement statement = con.createStatement();
            String query = "create table user(tid int(30) AUTO_INCREMENT primary key, name varchar(20) not null, age int(2) not null)";
            boolean success = statement.execute(query); // 'execute' returns true if the first result is a ResultSet, false if it is an update count or there are no results
          
            if (success)
                System.out.println("SUCCESS");
            else
                System.out.println("FAILURE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
