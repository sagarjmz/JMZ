package com.file;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmTestTaker extends HttpServlet {
	static Map map;
	static List list;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		HttpSession session = request.getSession();
		map =  FileOperation.map;
		int examId = Integer.parseInt(request.getParameter("id"));
		System.out.println("exam id is : " + examId);
		System.out.println(map.size());
		if (map.containsKey(examId)) {
			list = (List) map.get(examId);
			session.setAttribute("len", list.size());
			session.setAttribute("questions", list);
			request.setAttribute("examId",examId);
			request.setAttribute("id",request.getParameter("email"));
			map.remove(examId);
			response.sendRedirect("hpcode/view.jsp");

		} else {
			response.sendRedirect("http://localhost:8080/TEST_JMZ/hpcode/index.html");
		}
	}

}
