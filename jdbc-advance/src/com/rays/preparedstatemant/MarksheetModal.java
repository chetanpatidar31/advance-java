package com.rays.preparedstatemant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM 	marksheet WHERE rollNo=?");

			pstmt.setInt(1, bean.getRollNo());

			int i = pstmt.executeUpdate();
			System.out.println("Data Deleted Successfully...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

	public MarksheetBean findByPk(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where rollNo = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setRollNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPhy(rs.getInt(3));
			bean.setChm(rs.getInt(4));
			bean.setMaths(rs.getInt(5));
		}
		return bean;

	}
	
	public List search() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement pstmt=conn.prepareStatement("select * from marksheet");
		
		ResultSet rs=pstmt.executeQuery();
		
		List list = new ArrayList();
		
		MarksheetBean bean = null;
		while(rs.next()) {
			bean=new MarksheetBean();
			bean.setRollNo(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPhy(rs.getInt(3));
			bean.setChm(rs.getInt(4));
			bean.setMaths(rs.getInt(5));
			
			list.add(bean);
		}
		return list;
	}

}
