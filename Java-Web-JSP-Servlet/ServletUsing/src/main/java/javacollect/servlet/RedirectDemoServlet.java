package javacollect.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Forward by using Redirect
 * Redirect allows you to navigate to pages, including ones outside Website.*/

@WebServlet("/other/redirectDemo")
public class RedirectDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the value of parameter on the URL.
		String redirect = request.getParameter("redirect");

		if ("true".equals(redirect)) {
			System.out.println("Redirect to ShowMeServlet");

			// contextPath: Is an empty string "" or non-empty.
			// If it is non-empty, it always starts with /
			// and does not ends with /
			String contextPath = request.getContextPath();
			

			// ==> /ServletUsing/showme
			//Redirect the response to the other servlet - ShowMeServlet.java
			response.sendRedirect( contextPath + "/showme");
			return;
		}

		ServletOutputStream out = response.getOutputStream();
		out.println("<h3>Text of RedirectDemoServlet</h3>");
		out.println("- servletPath=" + request.getServletPath());
	
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
