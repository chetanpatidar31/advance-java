package com.rays.preparedstatemant;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDelete();
//		testUpdate();
//		testAuthenticate();
//		testFindByLogin();
		testFindById();
	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(6);
		bean.setFirst("MS");
		bean.setLast("Raina");
		bean.setLogin("suresh@gmail.com");
		bean.setPassword("suresh123");
		bean.setDob(sdf.parse("1983-03-11"));

		UserModel model = new UserModel();
		model.update(bean);

	}

	private static void testDelete() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setId(6);
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

		bean.setId(6);
		bean.setFirst("MS");
		bean.setLast("Dhoni");
		bean.setLogin("mahi@gmail.com");
		bean.setPassword("mahi123");
		bean.setDob(sdf.parse("1983-08-11"));

		model.add(bean);

	}

	private static void testAuthenticate() throws Exception {
		UserBean bean = new UserBean();
		UserModel modal = new UserModel();

		bean = modal.authenticate("mahi@gmil.com", "mahi123");

		if (bean != null) {
			System.out.println("user login successful");
			System.out.println(bean.getFirst());
			System.out.println(bean.getLast());
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
			System.out.println(bean.getFirst());
			System.out.println(bean.getLast());
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
			System.out.println(bean.getFirst());
			System.out.println(bean.getLast());
			System.out.println(bean.getDob());
		} else {
			System.out.println("invalid login id");
		}
	}
}
