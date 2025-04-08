package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// step 1 load driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 2 connection with database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		// step 3 create statement
		PreparedStatement pstmt = conn.prepareStatement("select * from employee");

//		step 4 execute query and get resultset
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t \t" + rs.getString(2));
			System.out.print("\t \t" + rs.getInt(3));
			System.out.print("\t \t" + rs.getString(4));
			System.out.println("\t \t" + rs.getInt(5));
		}

	}
}
