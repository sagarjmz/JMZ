package com.arraylist;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Arraylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Arraylist() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> listname=new ArrayList<String>();
		listname.add("rakesh");
		listname.add("ranjan");
		listname.add("ravi");
		listname.add("ramesh");
		
		HttpSession ses=request.getSession();
		ses.setAttribute("ArrList",listname);
		
		RequestDispatcher rd=request.getRequestDispatcher("JSP/New.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
