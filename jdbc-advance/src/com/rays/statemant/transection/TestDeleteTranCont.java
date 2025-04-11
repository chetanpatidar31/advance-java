package com.rays.statemant.transection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDeleteTranCont {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("delete from user where id=7");

			i = stmt.executeUpdate("delete from user where id=6");

			conn.commit();
			System.out.println("deleted...." + (i + i));
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
