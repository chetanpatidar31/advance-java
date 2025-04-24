package com.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private JDBCDataSource() {

	}

	private static JDBCDataSource dataSource = null;
	private static ComboPooledDataSource cpds = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

	private static JDBCDataSource getInstance() {
		if (dataSource == null) {

			dataSource = new JDBCDataSource();
			dataSource.cpds = new ComboPooledDataSource();

			try {
				dataSource.cpds.setDriverClass(rb.getString("driver"));
				dataSource.cpds.setUser(rb.getString("username"));
				dataSource.cpds.setPassword(rb.getString("password"));
				dataSource.cpds.setJdbcUrl(rb.getString("url"));
				dataSource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));
				dataSource.cpds.setMinPoolSize(Integer.parseInt(rb.getString("minPoolSize")));
				dataSource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
				dataSource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		return getInstance().cpds.getConnection();
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void trnRollback(Connection conn) throws Exception {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
