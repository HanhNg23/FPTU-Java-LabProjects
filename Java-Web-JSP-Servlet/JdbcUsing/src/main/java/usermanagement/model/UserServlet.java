package usermanagement.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.w3c.dom.Node;

import usermanagement.dao.UserDAO;
import usermanagement.model.User;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDAO userDao;
    public UserServlet() {
    	this.userDao  = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    String action = request.getServletPath();
	    switch(action) {
	    case "/new":
	    	try {
				showNewForm(request, response);
			} catch (SerialException | IOException | ServletException e) {
				e.printStackTrace();
			}
	    	break;
	    case "/insert":
	    	try {
				insertUser(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	break;
	    case "/delete":
	    	try {
				deleteUser(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	break;
	    case "/edit":
	    	try {
				showEditForm(request, response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	break;
	    case "/update":
	    	try {
				updateUser(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	break;
	    default:
	    	//handel list
	    	showAllUser(request, response);
	    	break;
	    }
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SerialException, IOException, ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	    dispatcher.forward(request, response);
	} 
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User user = new User(name, email, country);
		userDao.insertUser(user);
		response.sendRedirect("list");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	    request.setAttribute("user",  existingUser); //name: user value: existingUser
	    dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User user = new User(id,name, email, country);
		userDao.updateUser(user);
		response.sendRedirect("list");
	}
	
	private void showAllUser(HttpServletRequest request, HttpServletResponse respomse) throws ServletException, IOException {
		List<User> listUser = userDao.selectALLUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
	    dispatcher.forward(request, respomse);
	}
}
