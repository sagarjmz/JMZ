package com.file;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in service");
		
		if(FileOperation.count == 0)
		{
		FileOperation.mainEntry();
		}
		request.setAttribute("json",FileOperation.s1[0] );
		System.out.println(FileOperation.s1[0]);
		request.setAttribute("questions",FileOperation.list );
		RequestDispatcher rd = request.getRequestDispatcher("jsp/view.jsp");
		rd.forward(request, response);
	}

	
}
