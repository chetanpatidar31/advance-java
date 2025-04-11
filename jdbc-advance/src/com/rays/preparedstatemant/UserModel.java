package com.rays.preparedstatemant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {
	
	private String 	INSERT="";

	public static void add(UserBean bean) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		try {
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("Insert INTO user values(?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirst());
			pstmt.setString(3, bean.getLast());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();
			System.out.println("inserted...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

	public static void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		try {
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE id=?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			System.out.println("deleted...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

}
