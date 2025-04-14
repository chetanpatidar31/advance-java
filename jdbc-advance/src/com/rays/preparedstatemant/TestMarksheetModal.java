package com.rays.preparedstatemant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetModal {
	public static void main(String[] args) throws Exception {
//		add();
//		update();
//		delete();
//		testFindByPk();
		testSearch();
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

	private static void delete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModal model = new MarksheetModal();

		bean.setRollNo(112);
		model.delete(bean);

	}

	public static void testFindByPk() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModal modal = new MarksheetModal();

		bean = modal.findByPk(109);

		if (bean != null) {
			System.out.println("connection succesfully");
			System.out.println("Name : " + bean.getName());
			System.out.println("Physics : " + bean.getPhy());
			System.out.println("Chemistry : " + bean.getChm());
			System.out.println("Maths : " + bean.getMaths());
		} else {
			System.out.println("ID didn't match");
		}
	}

	public static void testSearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModal modal = new MarksheetModal();

		List list = new ArrayList();

		list = modal.search();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print(bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhy());
			System.out.print("\t" + bean.getChm());
			System.out.println("\t" + bean.getMaths());
		}
	}

}
