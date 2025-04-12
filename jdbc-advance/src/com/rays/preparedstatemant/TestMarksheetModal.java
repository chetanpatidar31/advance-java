package com.rays.preparedstatemant;

import java.sql.SQLException;

public class TestMarksheetModal {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		add();
//		update();
//		delete();
	}


	private static void add() throws ClassNotFoundException, SQLException {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModal model = new MarksheetModal();
		
		bean.setRollNo(120);
		bean.setName("Chanchal");
		bean.setPhy(78);
		bean.setChm(85);
		bean.setMaths(86);
		
		model.add(bean);
		
	}
	
	private static void update() throws ClassNotFoundException, SQLException {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModal model = new MarksheetModal();
		
		bean.setRollNo(113);
		bean.setName("Chinmay");
		bean.setPhy(58);
		bean.setChm(75);
		bean.setMaths(46);
		
		model.update(bean);
	}
	
	private static void delete() throws ClassNotFoundException, SQLException {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModal model = new MarksheetModal();
		
		bean.setRollNo(112);
		model.delete(bean);
		
		
	}
}
