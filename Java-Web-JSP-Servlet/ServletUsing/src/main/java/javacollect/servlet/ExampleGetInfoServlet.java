package javacollect.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/other/exampleInfo")
public class ExampleGetInfoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public ExampleGetInfoServlet(){
	       super();	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = resp.getOutputStream();
		out.println("<style> span {color:blue;} </style>");
		
		String requestURL = req.getRequestURL().toString();
		out.println("<br><span>requestURL: " + requestURL + "</span>");
		
		String requestURI = req.getRequestURI();
		out.println("<br><span>requestURI: " + requestURI + "</span>");

		String contextPath = req.getContextPath();
		out.println("<br><span>contextPath:</span>");
		out.println(contextPath);
		
		
		String param1 = req.getParameter("text1");
		out.println("<br><span>get value of Parameter text1: </span>");
		out.println(param1);
		
		out.println("<h2>SERVER INFO</h2>");
		
		out.println("<br><span>serverPort:  </span>");
		out.print(" " + req.getServerPort());
		
		out.println("<h2>CLIENT INFOS</h2>");
		out.println("<br><span>remoteAddr:</span>");
		String remoteAddr = req.getRemoteAddr();
		out.println(remoteAddr);
		

		String remoteHost = req.getRemoteHost();
		out.println("<br><span>remoteHost: </span>");
		out.println(remoteHost);
		
		
		out.println("<br><span>remoteUser:   </span>");
		String remoteUser = req.getRemoteUser();
		out.println(remoteUser);
		
		// Header Infos
		out.println("<br><br><b>headers:</b>");

		Enumeration<String> headers = req.getHeaderNames();
		int i = 0;
		
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			out.println("<br><span>" + header + " " + (i++) + "</span>: " + req.getHeader(header));
		}
		
		// Servlet Context info:
			out.println("<br><br><b>Servlet Context info:</b>");
			ServletContext servletContext = req.getServletContext();
			
			// Location of web application in hard disk
			out.println("<br><span>realPath in hard disk:  </span>");
			String realPath = servletContext.getRealPath("");
			out.println(realPath);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	


}
