package com.rays.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String id = request.getParameter("id");
		System.out.println("id: " + id);

		if (id != null) {
			try {
				bean = model.findById(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String op = request.getParameter("operation");
		String dob = request.getParameter("dob");
		
		
		try {
			bean.setFirstName(request.getParameter("firstName"));
			bean.setLastName(request.getParameter("lastName"));
			bean.setLogin(request.getParameter("login"));
			bean.setPassword(request.getParameter("password"));
			bean.setDob(sdf.parse(request.getParameter("dob")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// save
		if (op.equalsIgnoreCase("save")) {
			try {
				

				model.add(bean);
				request.setAttribute("msg", "User added Successfully");
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", e.getMessage());
			}
		}

		if (op.equalsIgnoreCase("update")) {
			bean.setId(Integer.parseInt(request.getParameter("id")));
			try {
				model.update(bean);
				request.setAttribute("msg", "User Updated Successfully");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);
	}
}
