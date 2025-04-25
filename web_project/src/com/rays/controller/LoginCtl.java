package com.rays.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");

		if (op != null && op.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate(); // destroy session
			request.setAttribute("msg", "user logout successfully");
		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String op = request.getParameter("operation");

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		if (op.equals("Signin")) {
			try {
				bean = model.authenticate(login, password);
				if (bean != null) {
					session.setAttribute("user", bean);
					response.sendRedirect("Welcome.jsp");
				} else {
					request.setAttribute("msg", "invalid login or password");
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
					rd.forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
