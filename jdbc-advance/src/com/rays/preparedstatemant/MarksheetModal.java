package com.rays.preparedstatemant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarksheetModal {

	public void add(MarksheetBean bean) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("Insert INTO marksheet values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getRollNo());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPhy());
			pstmt.setInt(4, bean.getChm());
			pstmt.setInt(5, bean.getMaths());

			int i = pstmt.executeUpdate();
			System.out.println("Data Inserted Successfully...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

	public void update(MarksheetBean bean) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("UPDATE marksheet set name=?,phy=?,chm=?,maths=? WHERE rollNo=?");

			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPhy());
			pstmt.setInt(3, bean.getChm());
			pstmt.setInt(4, bean.getMaths());
			pstmt.setInt(5, bean.getRollNo());

			int i = pstmt.executeUpdate();
			System.out.println("Data Updated Successfully...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}
	
	public void delete(MarksheetBean bean) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("DELETE FROM 	marksheet WHERE rollNo=?");

			pstmt.setInt(1, bean.getRollNo());

			int i = pstmt.executeUpdate();
			System.out.println("Data Deleted Successfully...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

}
