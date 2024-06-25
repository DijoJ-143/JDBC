package com.ust.JdbcToutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc1 {

	public static void main(String[] args) {
		try {
			// loading to memory
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection creation
			String url = "jdbc:mysql://localhost:3306/JDBC";
			String username = "root";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, username, password);
			// Statement

			if (conn.isClosed())
				System.out.println("connection is closed");
			else
				System.out.println("connection created");

			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("select * from user");

			while (result.next()) {
				// Assuming there are three columns in the 'trainees' table
				System.out.println(result.getInt(1) +"|" +result.getString(2) +"|"+ result.getInt(3)); // Assuming
																														// the
																														// first
																														// column
																														// is
																														// of
																														// type
																														// INT
				// Assuming the third column is of type VARCHAR
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
