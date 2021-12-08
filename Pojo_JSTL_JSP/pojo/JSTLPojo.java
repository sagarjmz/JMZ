package com.pojo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pojopackage.Pojo;

public class JSTLPojo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public JSTLPojo() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id1=request.getParameter("id");
		int  id=Integer.parseInt(id1);
		
		
		Pojo p=new Pojo();
		p.setId(id);
		p.setName("SIKHA");
		p.setPhone("9090628026");
		
		HttpSession ses=request.getSession();
		ses.setAttribute("Pojo", p);
		
		
		RequestDispatcher rd= request.getRequestDispatcher("JSP/File.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {}
	public void destroy() {}
		 
    }
