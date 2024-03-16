package com.usermanagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.dao.UserService_Impl;
import com.usermanagement.model.User;

@WebServlet(name = "userServlet", urlPatterns = "/")

public class UserServlet extends HttpServlet {

	UserService_Impl user = new UserService_Impl();

	public UserServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath(); 
		System.out.println("action: " + action);
		switch (action) {
		case "/insert": {
			this.insertUser(req, resp);
		}
		case "/update": {
			this.updateUser(req, resp);
		}
		case "/delete": {
			this.deleteUser(req, resp);
		}
		case "/showall": 
		default:
			try {
				this.showAllUser(req, resp);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	public void showAllUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		// Page: index.jsp (home page)
		List<User> userList = user.showAll();
		System.out.println("How many items in list : " + userList.size());

		req.setAttribute("list", userList);
		RequestDispatcher reqDis =  req.getRequestDispatcher("view/index.jsp");
		try {
			reqDis.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ListIterator<User> listIter = userList.listIterator();
		while (listIter.hasNext()) {
			User element = listIter.next();
			System.out.println(element.getId());
			System.out.println(element.getName());
			System.out.println(element.getEmail());
			System.out.println(element.getCountry());
		}
	}

	public void insertUser(HttpServletRequest req, HttpServletResponse resp) {
		// Page: UserForm.jsp To Fill Form and send request
		System.out.println("go to insert");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		boolean success = user.insert(new User(name, email, country));
		System.out.println("Insert result: " + (success == true ? "Success" : "Fail"));
		user.showAll();
	}

	public void updateUser(HttpServletRequest req, HttpServletResponse resp) {
		// Page: UserForm.jsp To Fill Form
	}

	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("-------DELETE GO-----");
		if (req.getParameter("id") != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			boolean success = user.delete(id);
			System.out.println("Insert result: " + (success == true ? "Success" : "Fail"));
			user.showAll();
		}	
			
	}

}
