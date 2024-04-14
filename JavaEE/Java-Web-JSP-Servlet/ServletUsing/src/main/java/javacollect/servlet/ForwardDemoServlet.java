package javacollect.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.authenticator.Constants;


/*Forward By Using RequestDispatcher 
 * Note: 
 *       Forward only allows to move to pages within Website, and can transfer
 *       data between two pages through request.setAttribute.
 * Syntax: 
 *       Dispatcher dispatcher = req.getServletContext().getRequestDispatcher(utl);
 *                             = req.getRequestDispatcher(url);*/
 


@WebServlet("/other/forwardDemo")
public class ForwardDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Request:
	// http://localhost:8080/Servlet_Tutor/other/forwardDemo?forward=true
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get value of parameter on URL.
		String forward = request.getParameter("forward");
		System.out.println("The value of 'forward' is " + forward);

		if ("true".equals(forward)) {
			System.out.println("Forward to ShowMeServlet");

			// Set data to attribute of the request.
			request.setAttribute("text", "Hi, I'm Tom come from Walt Disney !");
		} else {
			// Set data to attribute of the request.
			request.setAttribute("text", "Sorry you do not have permission to know the secret !");
		}

		// Get the Request Dispatcher object and pass
		// the argument to which servlet we need to call - ShowMeServlet.java
		RequestDispatcher dispatcher //
				= request.getServletContext().getRequestDispatcher("/showme");
		// Forward the Request Dispatcher object.
		dispatcher.forward(request, response);

		ServletOutputStream out = response.getOutputStream();
		out.println("<h3>Text of ForwardDemoServlet</h3>");
		out.println("- servletPath=" + request.getServletPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
