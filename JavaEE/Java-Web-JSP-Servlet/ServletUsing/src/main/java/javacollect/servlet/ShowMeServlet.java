package javacollect.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.authenticator.Constants;
import org.apache.tomcat.util.bcel.classfile.Constant;

@WebServlet("/showme")
public class ShowMeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowMeServlet() {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		ServletOutputStream out = resp.getOutputStream();
		out.println("<h1>Text Of ShowMeServlet</h1>");
		//Get the value of Constants.DEFAULT_JAAS_CONF from the request
		String text = (String) req.getAttribute("text");
		out.println("<h2>" + text + "</h2>");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
