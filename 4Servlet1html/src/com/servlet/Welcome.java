package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Welcome extends HttpServlet 
{
	

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.getWriter().print("<!DOCTYPE html>\n"
			+ "<html>\n"
			+ "<head>\n"
			+ "<meta charset=\"UTF-8\">\n"
			+ "<title>Address</title>\n"
			+ "<style>\n"
			+ "form {\n"
			+ "	border-color: black;\n"
			+ "	border-style: solid;\n"
			+ "	padding: 100px;\n"
			+ "	display: inline-block;\n"
			+ "	font-size: 25px;\n"
			+ "	text-align: center;\n"
			+ "	align: center;\n"
			+ "}\n"
			+ "\n"
			+ "form:hover {\n"
			+ "	border-color: red;\n"
			+ "}\n"
			+ "\n"
			+ ".s {\n"
			+ "	padding: 5px;\n"
			+ "	color: black;\n"
			+ "	font-size: 17px;\n"
			+ "	width: 100px;\n"
			+ "	background-color: white;\n"
			+ "	text-decoration: none;\n"
			+ "}\n"
			+ "\n"
			+ "input:hover {\n"
			+ "	border-color: black;\n"
			+ "}\n"
			+ "\n"
			+ "label:hover {\n"
			+ "	font-size: 26px;\n"
			+ "}\n"
			+ "\n"
			+ "input {\n"
			+ "	font-size: 20px;\n"
			+ "	padding: 10px;\n"
			+ "	width: 200px;\n"
			+ "}\n"
			+ "\n"
			+ "a {\n"
			+ "	border: 2px solid black;\n"
			+ "	padding: 5px;\n"
			+ "	font-size: 17px;\n"
			+ "	text-decoration: none;\n"
			+ "	color: black;\n"
			+ "}\n"
			+ "\n"
			+ "a:hover {\n"
			+ "	\n"
			+ "}\n"
			+ "</style>\n"
			+ "</head>\n"
			+ "<body>\n"
			+ "<h1>Address form</h1>\n"
			+ "<!-- onsubmit=\"return validateForm()\" -->\n"
			+ "	<form action=\"One\" name=\"form\" method=\"post\">\n"
			+ "		<label>Enter Address : </label> &nbsp;<input type=\"text\" name=\"address\" ><br><!-- pattern=\"[A-Za-z]+\" -->\n"
			+ "		<br> <label>Enter city :</label> &nbsp;&nbsp;&nbsp;<input\n"
			+ "			type=\"text\" name=\"city\" ><br> <br> \n"
			+ "			<label>Enter pin :</label> &nbsp;&nbsp;&nbsp;<input\n"
			+ "			type=\"text\" name=\"pin\" ><br> <br>\n"
			+ "			<label>Enter Street :</label> &nbsp;&nbsp;&nbsp;<input\n"
			+ "			type=\"text\" name=\"street\" ><br> <br>\n"
			+ "			<input class=\"s\" type=\"submit\" value=\"Submit\">&nbsp;\n"
			+ "			<input class=\"s\" type=\"reset\" value=\"reset\">&nbsp; \n"
			+ "\n"
			+ "\n"
			+ "	</form>\n"
			+ "</body>\n"
			+ "</html>");
}

}
