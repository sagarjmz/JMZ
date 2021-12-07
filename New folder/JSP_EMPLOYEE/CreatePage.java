package com.jshx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Pojo;

public class CreatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CreatePage() {
        super();
        
    }

    Connection con;
	String url = "jdbc:mysql://localhost:3306/hpdata";
	String uname = "root";
	String pwd = "tiger";
	public void init(ServletConfig config) throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int salary1=0;
		String design = (request.getParameter("desig"));
		
		int min = 001;
		int max = 999;
		double empid2 = Math.random() * (max - min + 1) + min;
		int empid1 = (int) Math.round(empid2);
		String id = Integer.toString(empid1);
		// String id1 = String.valueOf(id);
		
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM");
		LocalDateTime now = LocalDateTime.now();
		String id1 = dateformat.format(now); // display current yyyy/month from system
		String[] id2arr = id1.split("/");
		id = id2arr[0] + "JMZ" + id2arr[1] + id;
		//System.out.println("hiiiiiiiiiii");
		
		PreparedStatement pst1 = con.prepareStatement("SELECT salary FROM desigemployee WHERE empDesignation = ?");
		pst1.setString(1, design);
		
		ResultSet rs = pst1.executeQuery();
		if (rs.next()) {
		salary1 = rs.getInt("salary");
		//System.out.println(salary1);
		}
		//RequestDispatcher r1 = request.getRequestDispatcher("/DBClass");
		//r1.include(request, response);
		/*
		 * PreparedStatement pst1 = con.
		 * prepareStatement("SELECT emp_salary FROM student WHERE emp_designation = ?");
		 * 
		 * pst1.setString(1, design); ResultSet rs = pst1.executeQuery(); if (rs.next())
		 * { salary1 = rs.getInt(1); }
		 */
		//HttpSession session=request.getSession();
		//String address= request.getParameter("address");
		//session.setAttribute("a",request.getParameter("uname"));
		PreparedStatement pst;
		
		Pojo p=new Pojo(id, request.getParameter("uname"), Integer.parseInt(request.getParameter("age")), request.getParameter("desig"), salary1);
			
		pst = con.prepareStatement("insert into student values(?,?,?,?,?)");
			pst.setString(1, p.getId());
			pst.setString(2, p.getUname());
			pst.setInt(3, p.getAge());
			pst.setString(4, p.getDesig());
			//int salary = 30000;
			pst.setInt(5, p.getSalary());
			
			
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = st.executeQuery("select * from student");
			rs1.last();
			if (rs1.getRow() >= 10) {
				rs1.absolute(1);
				rs1.deleteRow();
				int r = pst.executeUpdate();
				
				if (r == 1) {
					pw.println(" <html><head><center></head>"
							+ "<body style=\"color:black; font-size:30px; background-color:#9F1ABC\"> "
							+ "DATA INSERTED </body></html> ");
					pw.println("</br>");
					pw.println("</br>");
					pw.println("</br>");
					pw.println(id + " "+request.getParameter("uname") +" "+ request.getParameter("desig"));
					//response.sendRedirect("CreatePage");
				} else {
					pw.println(" <html><head><center></head>"
							+ "<body style=\"color: red; font-size:32px;; background-color: sky\">"
							+ "INSERTION FAILED</body></html> ");
					}
			}else {
				int r = pst.executeUpdate();
				
				if (r == 1) {
					pw.println(" <html><head><center></head>"
							+ "<body style=\"color:black; font-size:30px; background-color:#9F1ABC\"> "
							+ "DATA INSERTED </body></html> ");
					pw.println("</br>");
					pw.println("</br>");
					pw.println("</br>");
					pw.println(id + " "+request.getParameter("uname") +" "+ request.getParameter("desig"));
				} else {
					pw.println(" <html><head><center></head>"
							+ "<body style=\"color: red; font-size:32px;; background-color: sky\">"
							+ "INSERTION FAILED</body></html> ");
					}
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			//session.setAttribute("b",request.getParameter("age"));
			//session.setAttribute("c",request.getParameter("desig"));
			}
		
		

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
