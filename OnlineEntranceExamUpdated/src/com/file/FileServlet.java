package com.file;

import java.io.IOException;

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
		FileOperation.range = 2;
//		int num = Integer.parseInt(request.getParameter("range"));
//		if(num==0)
//		{
//			FileOperation.range = 5;
//		}
//		else
//		{
//			FileOperation.range = num;
//		}
		FileOperation.fileName = "Java";
//		
		
		
		FileOperation.mainEntry();

		
		HttpSession session = request.getSession();

		System.out.println(FileOperation.list.size());
		session.setAttribute("email", request.getParameter("email"));
		session.setAttribute("len", FileOperation.list.size());
		session.setAttribute("questions", FileOperation.list);
		response.sendRedirect("hpcode/view.jsp");

	}

}
