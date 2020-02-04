package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShoppingList")
public class ShoppingList extends HttpServlet {
	protected Boolean blankField = true;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized (session) {
			String itemRequest = request.getParameter("Item");
			blankField = (checkParam(itemRequest, "Shopping item"));
			PrintWriter out = response.getWriter();
			String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

			if (blankField) {
				out.println(docType + "<HTML>" + "<HEAD><TITLE>Order Form</TITLE></HEAD>" + "<BODY>" + "<CENTER>"
						+ "<H1>" + "Welcome Back" + "</H1>" + "<FORM ACTION='ShoppingList' METHOD='GET'>"
						+ "<TABLE BORDER=1 CELLPADDING=5 CELLSPACING=0>" + "<TR>" + "<TD>Shopping Item:</TD>"
						+ "<TD><INPUT TYPE='TEXT' NAME='Item' maxlength='20' size='25'>" + StartMyShopping.warning
						+ "</TD>" + "</TR>" + "</TABLE>"
						+ "<br><BUTTON TYPE='SUBMIT' NAME='AddBtn' VALUE='AddBtn' size=80>Add to Shopping List</BUTTON>"
						+ "</FORM>" + "</CENTER></BODY></HTML>");
			} else {
				//String previousItems = checkSession(session.getAttribute("previousItems"));
				HashSet<String> itemsList = checkSession(session.getAttribute("previousItems"));
				//if (previousItems != "")
					//itemsList.add(previousItems);
				itemsList.add(itemRequest);
				session.setAttribute("previousItems", itemsList);
				Iterator<String> iteratedList = itemsList.iterator();

				out.println(docType + "<HTML>" + "<HEAD>" + "<TITLE>Shopping List</TITLE>" + "</HEAD>" + "<BODY>"
						+ "<CENTER>" + "<H1>Shopping List</H1>" + "<UL>");
				while (iteratedList.hasNext())
					out.println("<LI>" + iteratedList.next() + "</LI>");

				out.println("</UL>" + "<br><a href='StartMyShopping'>Keep Shopping >></a><br><br>" + "</CENTER>"
						+ "</BODY></HTML>");
			}
		}
	}

	public Boolean checkParam(String value, String valueName) {

		if (value.length() == 0 || value.isEmpty() || value.equals(null) || (value.trim().equals(""))) {
			StartMyShopping.warning = "<B><FONT COLOR=RED>" + "Please enter " + valueName + "</FONT></B>";
			return true;
		} else {
			StartMyShopping.warning = "";
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	private HashSet<String> checkSession(Object sessionVal) {
		if (sessionVal != null)
			return (HashSet<String>) (sessionVal);
		else
			return  new HashSet<String>();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
