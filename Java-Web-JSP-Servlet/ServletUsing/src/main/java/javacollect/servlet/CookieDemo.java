package javacollect.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyJavaServlet")
public class CookieDemo {
	private static final long serialVersionUID = 1L;

	/**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CookieDemo() {
	        super();
	    }

	/**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        // TODO Auto-generated method stub
	 
	        PrintWriter myResponse = response.getWriter();
	         
	        String message = "This is your response from a POST call. <br> The response is a Java Servlet !";
	         
	        Cookie name = new Cookie("name",  request.getParameter("name"));
	        
	        // Set expiry date after 1 hour for this cookie.
	        name.setMaxAge(60*60*2);
	        name.setDomain("localhost");
	        name.setPath("/");
	         
	        // Add the cookie to the response header.
	        response.addCookie(name);
	        
	        myResponse.println( "\n" + 
	             "<title> Example of using Java Servlet with POST Call Method !</title>\n" +
	             "\n" +
	             "<h2 align="\"center\"">" + message + "</h2>\n" +
	             "<ul>\n" +
	             "  <li><b>You entered the name </b>: "       + request.getParameter("name") + "\n" +
	             "  </li><li><b>You entered the telephone# </b>: " + request.getParameter("telephone") + "\n" +
	             "</li></ul>\n <p>   </p>  <p>Link to HTML page : "+
	             "  <a href="http://localhost:8080/Java_cookies/page2.html">link</a></p>" +
	             "");
	 
	         
	         
	         
	    }
}
