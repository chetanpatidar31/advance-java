package com.rays.controller;

import java.io.IOException;
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

@WebServlet("/AddUserCtl")
public class AddUserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddUserView.jsp");
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

		if (op.equalsIgnoreCase("save")) {
			try {
				bean.setFirstName(request.getParameter("firstName"));
				bean.setLastName(request.getParameter("lastName"));
				bean.setLogin(request.getParameter("login"));
				bean.setPassword(request.getParameter("password"));
				bean.setDob(sdf.parse(request.getParameter("dob")));

				model.add(bean);

				request.setAttribute("msg", "User added Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", e.getMessage());
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("AddUserView.jsp");
		rd.forward(request, response);
	}
}
