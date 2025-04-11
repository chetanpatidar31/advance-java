package com.rays.preparedstatemant;

import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		//testAdd();
		testDelete();
		testUpdate();
	}

	private static void testUpdate() {
		UserModel model= new UserModel();
		
		
		model.update();
		
	}

	private static void testDelete() throws Exception {
		UserModel model = new UserModel();
		
		model.delete(6);
	
		
	}

	private static void testAdd() throws Exception {
		UserBean bean=new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setId(6);
		bean.setFirst("Yuzi");
		bean.setLast("Chahal");
		bean.setLogin("yuzi@gmail.com");
		bean.setPassword("yuzi123");
		bean.setDob(sdf.parse("1992-05-18"));
		
		model.add(bean);
		
	}
}
