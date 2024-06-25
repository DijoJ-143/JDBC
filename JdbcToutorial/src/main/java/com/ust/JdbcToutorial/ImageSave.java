package com.ust.JdbcToutorial;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;

public class ImageSave {

	public static void main(String[] args) {
		try {
			// class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// connectiom
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

			// query and passing to statement
			String query = "insert into images(pic) values(?)";
			PreparedStatement stmt = con.prepareStatement(query);

			// providing values
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(null);
			File file = jfc.getSelectedFile();

			FileInputStream fis = new FileInputStream(file);

			stmt.setBinaryStream(1, fis, fis.available());

//			FileInputStream fis = new FileInputStream(
//					"C:\\Users\\269661\\Downloads\\JDBC\\JdbcToutorial\\src\\main\\java\\com\\ust\\JdbcToutorial\\images\\img1.jpg");
//			stmt.setBinaryStream(1, fis);

			// execute
			int i = stmt.executeUpdate();

			if (i == 1)

				
				System.err.println("pic loaded into dB /JDBC/");
			else
				System.out.println("FAILED TO LOAD");
			
			con.close();
			
			if(con.isClosed() && i==1)
				System.out.println("Updated and connection closed successfully");
			else if(con.isClosed())
				System.out.println(" closed  the connection only but not updated");
			else
				System.err.println(" need to close  the connection");

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("error: " + e.getMessage());
		}
	}

}
