package javacollect.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*Default Servlet:
 Servlet with url-pattern  = /
 ==> As a default servlet, servlet will be used for processing the requests
that the path does not match any url-pattern of the Servlet is declared 
in your application.*/

@WebServlet(urlPatterns = {"/"})
public class MyDefaultServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyDefaultServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        ServletOutputStream out = resp.getOutputStream();
	        
	        out.println("<html>");
	        out.println("<head><title>Page not found</title></head>");
	        out.println("<body>");
	        out.println("<h3>Sorry! Page not found</h3>");
	        out.println("<h1>404 ERROR</h1>");
	        out.println("Message from servlet: " + this.getClass().getName());
	        out.println("</body>");
	        out.println("</html>");        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	

}
