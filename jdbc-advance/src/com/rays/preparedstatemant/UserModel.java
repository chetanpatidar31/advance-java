package com.rays.preparedstatemant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.rays.util.JDBCDataSource;

public class UserModel {

	public void add(UserBean bean) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			UserBean existBean = findByLogin(bean.getLogin());
			if (existBean != null) {
				throw new Exception("Login id already exist");
			}

			PreparedStatement pstmt = conn.prepareStatement("Insert INTO user values(?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();
			System.out.println("Data Inserted Successfully...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

	public void deleteWithId(int id) throws Exception {

		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE id=?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			System.out.println("Data Deleted Successfully...." + i);

			conn.commit();

		} catch (

		Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

	public void delete(UserBean bean) throws Exception {
		Connection conn = null;
		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE id=?");

			pstmt.setInt(1, bean.getId());

			int i = pstmt.executeUpdate();

			System.out.println("Data Deleted Successfully...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

	public void update(UserBean bean) throws SQLException {
		Connection conn = null;
		try {
			conn=JDBCDataSource.getConnection();
			
			conn.setAutoCommit(false);

			UserBean existBean = findByLogin(bean.getLogin());

			PreparedStatement pstmt = conn
					.prepareStatement("UPDATE user SET firstName=?,lastName=?,login=?,password=?,dob=? WHERE id=?");
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setInt(6, bean.getId());

			int i = pstmt.executeUpdate();

			System.out.println("Data Updated Successfully...." + i);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

	public UserBean authenticate(String login, String password) throws SQLException, ClassNotFoundException {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user Where login=? and password=?");

		pstmt.setString(1, login);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}
		return bean;

	}

	public UserBean findByLogin(String login) throws SQLException, ClassNotFoundException {

		Connection conn = JDBCDataSource.getConnection();
		
		conn.setAutoCommit(false);

		PreparedStatement pstmt = conn.prepareStatement("select * from user Where login=?");

		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}
		return bean;

	}

	public UserBean findById(int id) throws Exception {

		Connection conn= JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("select * from user Where id=?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}
		return bean;
	}

	public List search(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from user where 1 = 1");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "%'");
			}

			if (bean.getLastName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastName() + "%'");
			}
		}
		System.out.println("sql : " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

			list.add(bean);
		}

		return list;
	}
}
