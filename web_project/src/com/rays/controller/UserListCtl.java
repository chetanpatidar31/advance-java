package com.rays.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// User list
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		List list = new ArrayList();

		try {
			list = model.search(bean);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		String op = request.getParameter("operation");

		String[] ids = request.getParameterValues("ids");
		// delete
		if (op.equalsIgnoreCase("delete")) {

			if (ids != null && ids.length > 0) {

				for (String id : ids) {
					bean.setId(Integer.parseInt(id));

					try {
						model.delete(bean);
						request.setAttribute("msg", "User deleted successfuly");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} else {
				request.setAttribute("msg", "Select atleast one Record");
			}

		}

		// Search
		if (op.equalsIgnoreCase("search")) {

			try {
				bean.setFirstName(request.getParameter("firstName"));
				bean.setLastName(request.getParameter("lastName"));
				bean.setLogin(request.getParameter("login"));
				String dob = request.getParameter("dob");
				System.out.println(dob);
				bean.setDob(sdf.parse(dob));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		// Userlist
		try {
			List list = model.search(bean);
			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	};
}
