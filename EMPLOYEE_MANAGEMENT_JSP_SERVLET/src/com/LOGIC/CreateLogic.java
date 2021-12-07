package com.LOGIC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBClass;
import com.TO.Employee;

/**
 * Servlet implementation class CreateLogic
 */
public class CreateLogic extends HttpServlet {
	static Connection con;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text,html");
			PrintWriter out = response.getWriter();
			con = DBClass.con;
			int salary = 0;
			String designation = request.getParameter("desig");
			Random rand = new Random();
			int rand_int = rand.nextInt(99);
			String id2 = String.valueOf(rand_int);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");
			LocalDateTime now = LocalDateTime.now();
			String id1 = dtf.format(now);
			String[] id1Arr = id1.split("/");
			String id = id1Arr[0] + "JMZ" + id1Arr[1] + id2;
			RequestDispatcher r1 = request.getRequestDispatcher("/DBClass");
			r1.include(request, response);
			PreparedStatement pst1 = con.prepareStatement("SELECT salary FROM desigEmployee WHERE empDesignation = ?");
			pst1.setString(1, designation);
			ResultSet rs = pst1.executeQuery();
			if (rs.next()) {
				salary = rs.getInt(1);
			}
			PreparedStatement pst = con.prepareStatement("insert into finalemp values(?,?,?,?,?)");
			
			Employee e = new Employee(id, request.getParameter("uname"), Integer.parseInt(request.getParameter("age")), request.getParameter("desig"), salary );
			
			pst.setString(1, e.getEmpId());
			pst.setString(2, e.getName());
			pst.setInt(3, e.getage());
			pst.setString(4, e.getDesignation());
			pst.setInt(5, e.getSalary());
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = st.executeQuery("select * from finalemp");
			rs1.last();
			if (rs1.getRow() >= 10) {
				rs1.absolute(1);
				rs1.deleteRow();

				int r = pst.executeUpdate();
				if (r == 1) {
					response.sendRedirect("jsp/Index.jsp");
				} else {
					out.println(
							" <html><head><center></head><body style=\"color: red; font-size:32px;; background-color: sky\"><<<<< INSERTION FAILED >>>>></body></html> ");
				}

			} else {
				int r = pst.executeUpdate();
				if (r == 1) {
					response.sendRedirect("jsp/Index.jsp");
				} else {
					out.println(
							" <html><head><center></head><body style=\"color: red; font-size:32px;; background-color: sky\"><<<<< INSERTION FAILED >>>>></body></html> ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
