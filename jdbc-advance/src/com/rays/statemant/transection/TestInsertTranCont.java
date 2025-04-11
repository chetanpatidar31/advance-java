package com.rays.statemant.transection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertTranCont {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into user values(6,'Rahul','Chahar','rahul@gmil.com','rahul123','1987-11-05')");

			i = stmt.executeUpdate(
					"insert into user values(7,'Deepak','Chahar','deepak@gmil.com','deepak123','1995-08-25')");

			i = stmt.executeUpdate(
					"insert into user values(5,'Jaspreet','Bumrah','jbumrah@gmil.com','jaspreet123','1995-08-25')");

			conn.commit();

			System.out.println("Inserted...." + (i + i + i));
		} catch (Exception e) {
			conn.rollback();

			System.out.println(e.getMessage());
			e.printStackTrace();

		}

	}
}
