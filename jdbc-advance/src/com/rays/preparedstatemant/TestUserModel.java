package com.rays.preparedstatemant;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		
		testAdd();
//		testDelete();
//		testUpdate();
//		testAuthenticate();
//		testFindByLogin();
//		testFindById();
//		testSearch();
	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(1);
		bean.setFirstName("Rohit");
		bean.setLastName("Sharma");
		bean.setLogin("rohit@gmail.com");
		bean.setPassword("rohit123");
		bean.setDob(sdf.parse("1987-04-30"));

		UserModel model = new UserModel();
		model.update(bean);

	}

	private static void testDelete() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(15);
		model.delete(bean);

	}

	private static void testDeleteWithId() throws Exception {
		UserModel model = new UserModel();

		model.deleteWithId(6);

	}

	private static void testAdd() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(2);
		bean.setFirstName("Virat");
		bean.setLastName("Kohli");
		bean.setLogin("virat@gmail.com");
		bean.setPassword("virat123");
		bean.setDob(sdf.parse("1988-11-09"));

		model.add(bean);

	}

	private static void testAuthenticate() throws Exception {
		UserBean bean = new UserBean();
		UserModel modal = new UserModel();

		bean = modal.authenticate("mahi@gmil.com", "mahi123");

		if (bean != null) {
			System.out.println("user login successful");
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
		} else {
			System.out.println("invalid login id or password");
		}
	}

	private static void testFindByLogin() throws Exception {
		UserBean bean = new UserBean();
		UserModel modal = new UserModel();

		bean = modal.findByLogin("mahi@gmail.com");

		if (bean != null) {
			System.out.println("user login successful");
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
		} else {
			System.out.println("invalid login id");
		}
	}

	private static void testFindById() throws Exception {
		UserBean bean = new UserBean();
		UserModel modal = new UserModel();

		bean = modal.findById(7);

		if (bean != null) {
			System.out.println("user login successful");
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
		} else {
			System.out.println("invalid login id");
		}
	}

	public static void testSearch() throws Exception {

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		List list = new ArrayList();

		 bean.setFirstName("Rohit");
		// bean.setLastName("Kohli");

		list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());

		}

	}
}