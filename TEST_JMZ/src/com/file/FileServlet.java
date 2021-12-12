package com.file;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in service");
		FileOperation.list.clear();
		FileOperation.range = 5;

		FileOperation.fileName = "Java";
	
		//***********
		
		FileOperation.mainEntry();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		

		
		HttpSession session = request.getSession();

		System.out.println(FileOperation.list.size());
		session.setAttribute("email", request.getParameter("email"));
		session.setAttribute("date", dtf.format(now)); //*********
		session.setAttribute("len", FileOperation.list.size());
		session.setAttribute("questions", FileOperation.list);
		response.sendRedirect("hpcode/view.jsp");

	}

}
