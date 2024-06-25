 package com.ust.JdbcToutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbcInsert {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/JDBC";
			String password = "root";
			String username = "root";
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "insert into user(name,age) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(query);

//			ps.setInt(1, 1);
			ps.setString(1, "DIJO");
			ps.setInt(2, 27);

			int i = ps.executeUpdate();

			if (i == 1)
				System.out.println("UPDATE SUCCESSFUL");
			else
				System.out.println("UPDATE UNSUCCESSFUL");

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

	}

}
