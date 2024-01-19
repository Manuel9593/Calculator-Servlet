package calculator;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CalcServlet
 */
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print(format(0,0,Integer.MIN_VALUE));
	}
	
	private int calc(int a, int b, String op) {
		switch(op) {
			case "add":
				return a + b;
			case "sub":
				return a - b;
			case "mul":
				return a * b;
			case "div":
				return (int) (a/b);
			default:
				return Integer.MIN_VALUE;
		}
	}
	
	private String format(int a, int b, int ris) {
		String s = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<form method=\"post\">\r\n"
				+ "		<div>A:<input type=\"number\" name=\"a\" value=\""+a+"\"></div>\r\n"
				+ "		<div>B:<input type=\"number\" name=\"b\" value=\""+b+"\"></div>\r\n"
				+ "     <div>"+(ris != Integer.MIN_VALUE ? ris : "")+"</div>\r\n"
				+ "		<div>\r\n"
				+ "			<input type=\"submit\" name=\"op\" value=\"add\">\r\n"
				+ "			<input type=\"submit\" name=\"op\" value=\"sub\">\r\n"
				+ "			<input type=\"submit\" name=\"op\" value=\"mul\">\r\n"
				+ "			<input type=\"submit\" name=\"op\" value=\"div\">\r\n"
				+ "		</div>\r\n"
				+ "	</form>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		return s;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		String op = request.getParameter("op");
		
		int ris = calc(a,b,op);
		response.getWriter().print(format(a,b,ris));
	}

}
