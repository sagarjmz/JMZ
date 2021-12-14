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
		FileOperation.listFinal.clear();
		FileOperation.range = 2;
		System.out.println(FileOperation.range + ": range");

		FileOperation.fileName = "Java";
		System.out.println("file name : " + FileOperation.fileName);

		FileOperation.mainEntry(10);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();

		HttpSession session = request.getSession();

		System.out.println(FileOperation.listFinal.size());
//		session.setAttribute("email", request.getParameter("email"));
//		session.setAttribute("date", dtf.format(now)); // *********
		session.setAttribute("len", FileOperation.listFinal.size());
		session.setAttribute("questions", FileOperation.listFinal);
		response.sendRedirect("hpcode/view.jsp");

	}

}
