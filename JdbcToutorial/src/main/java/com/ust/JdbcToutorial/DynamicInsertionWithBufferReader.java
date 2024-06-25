package com.ust.JdbcToutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicInsertionWithBufferReader {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/JDBC";
			String un = "root";
			String pass = "root";

			Connection con = DriverManager.getConnection(url, un, pass);
			String query = "insert into user(name,age) values(?,?)";
			PreparedStatement statement = con.prepareStatement(query);
			
			//buffer reader
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter user name: ");
			String name = br.readLine();
			
			//if integer type then we need to parse it to integer type
			System.out.println("enter user age:");
			int age = sc.nextInt();

			statement.setString(1, name);
			statement.setInt(2, age);

			int i = statement.executeUpdate();

			if (i == 1) {
				Statement s = con.createStatement();
				ResultSet result = s.executeQuery("select * from user");

				while (result.next()) {
					System.err.println(result.getInt(1) + "		|	" + result.getString(2) + "		|	" + result.getInt(3));
				}
			

			}
			else
				System.err.println("Error encountered");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
