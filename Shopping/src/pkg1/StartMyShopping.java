package pkg1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/StartMyShopping")
public class StartMyShopping extends HttpServlet {
	static String warning = "";
	protected String title = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			String repeatedCustomer = checkSession(session.getAttribute("repeatedCustomer"));
			if (repeatedCustomer == "NULL") {
				session.setAttribute("repeatedCustomer", "yes");
				title = "Welcome New Visitor";
				
				
			}
			else if (repeatedCustomer != "Null")
				title = "Welcome Back";
				
			
			String orderForm = "<HTML>" + "<HEAD><TITLE>Order Form</TITLE></HEAD>" + "<BODY>" + "<CENTER>" + "<H1>"
					+ title + "</H1>" + "<FORM ACTION='ShoppingList' METHOD='GET'>"
					+ "<TABLE BORDER=1 CELLPADDING=5 CELLSPACING=0>" + "<TR>" + "<TD>Shopping Item:</TD>"
					+ "<TD><INPUT TYPE='TEXT' NAME='Item' maxlength='20' size='25'>" + "</TD>" + "</TR>" + "</TABLE>"
					+ "<br><BUTTON TYPE='SUBMIT' NAME='AddBtn' VALUE='AddBtn' size=80>Add to Shopping List</BUTTON>"
					+ "</FORM>" + "</CENTER></BODY></HTML>";

			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
			out.println(docType + orderForm);

		}

	}

	private String checkSession(Object sessionVal) {
		if (sessionVal != null)
			return ((String) sessionVal);
		else
			return ("NULL");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
