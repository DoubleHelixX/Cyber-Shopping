package pkg1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/cyber-shopping")
public class CyberShopping extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String message = "Only Microsoft IE browser is working for this site.";
		String userAgent = request.getHeader("User-Agent");
		boolean repeatedVisitor = false;

		if ((userAgent != null) && (userAgent.contains("Trident") == false))
			response.sendError(HttpServletResponse.SC_NOT_FOUND, message);
		else {
			Cookie[] cookies = request.getCookies();

			if (cookies != null) {
				for (Cookie c : cookies) {
					if ((c.getName().equals("Visit")) && (c.getValue().equals("yes"))) {
						repeatedVisitor = true;
						break;
					}
				}
			}
			if (repeatedVisitor==false)
			{
				Cookie Visit = new Cookie("Visit", "yes");
				Visit.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(Visit);
			}
			
			response.sendRedirect("StartMyShopping");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
