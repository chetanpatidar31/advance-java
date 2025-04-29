package com.rays.model;

import java.text.SimpleDateFormat;

import com.rays.bean.UserBean;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		testModel();
	}

	private static void testModel() throws Exception {
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
}
