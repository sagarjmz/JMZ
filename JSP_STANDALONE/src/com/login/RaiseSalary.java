package com.login;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBUtil;

/**
 * Servlet implementation class RaiseSalary
 */
public class RaiseSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RaiseSalary() {
		super();
		// TODO Auto-generated constructor stub
	}

	Connection con;
	

	public void init(ServletConfig config) throws ServletException {
		try {
			con=DBUtil.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//int salary=0;
//		try {
//			response.setContentType("text/html");
//			PrintWriter pw = response.getWriter();
////			 HttpSession session=request.getSession();
////			 String uname=(String) session.getAttribute("name");
//			 String id=request.getParameter("id");
//			pw.println();
//			Statement st = con.createStatement();
//			//PreparedStatement pst1 = con.prepareStatement("SELECT empsalary FROM new_table WHERE empid = ?");
//			ResultSet rs = st.executeQuery("SELECT empsalary FROM new_table WHERE empid = ?");
////			ResultSet rs1 = null;
////			List<String> listId = new ArrayList<String>();
////			while (rs.next()) {
////				listId.add(rs.getString(1));
////			}
////			if (listId.contains(request.getParameter("id"))) {
////				pst1.setString(1, request.getParameter("id"));
////				rs1 = pst1.executeQuery();
//				if(rs.next()) {
//				salary=rs.getInt(5);
//				}
//					String nm = rs1.getString(1);
//					int sal = rs1.getInt(5);
//					if (request.getParameter("empid").equalsIgnoreCase(nm)) {
////						HttpSession s = request.getSession();
////						s.setAttribute("id", request.getParameter("id"));
////						s.setAttribute("sal", sal);
//						pw.println();
//						
//					} else {
//						pw.println("\n");
//						pw.println(" <html><head><center></head>"
//								+ "<body style=\"color:red; font-size:32px;; background-color:red\">"
//								+ "UPDATION FAILED</body></html> ");
//
//					}
//				}
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int salary=0;
		Statement st = null;
		try {
//PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			PrintWriter pw2 = response.getWriter();
		
			String id=request.getParameter("id");
			int salary=Integer.parseInt(request.getParameter("salary"));
			System.out.println(id);
			System.out.println(salary);
//			ResultSet rs=st.executeQuery("select empsalary from new_table where empid='"+id+"'");
//			if(rs.next()) {
//				salary=rs.getInt(5);
//				System.out.println(salary);
//			}
//			//HttpSession s = request.getSession();
			

//			String id = (String) s.getAttribute("id");
//			int sal = (Integer) s.getAttribute("sal");
			int p = Integer.parseInt(request.getParameter("percentage"));
			salary = salary + ((salary * p) / 100);
			PreparedStatement pst = con.prepareStatement("update new_table set empsalary = ? where empid = ?");
			pst.setInt(1, salary);
			pst.setString(2, id);
			int r = pst.executeUpdate();
			if (r == 1) {
//				response.setContentType("text/html");
//				PrintWriter pw1 = response.getWriter();
//
//				pw1.println("\n");
//				pw1.println(" <html><head><center></head><body style=\"background-color:yellow\" "
//						+ "<br><br><br><br><h1>DATA UPDATED SUCCESSFULLY</h1>" + "</body></html> ");
				response.sendRedirect("JSP/Display.jsp");
			}
		} catch (Exception e) {

		}
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