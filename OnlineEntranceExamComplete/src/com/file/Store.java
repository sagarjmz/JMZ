package com.file;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.YearMonth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Store")
public class Store extends HttpServlet {
	static String url = "jdbc:mysql://localhost:3306/project";
	static String usr = "root";
	static String pwd = "prabhakar";
	public static Connection con;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pwd);
		} catch (Exception e) {
// 
			e.printStackTrace();
		}

		PrintWriter pw = response.getWriter();
		System.out.println("result vales : "+request.getParameter("result") + " " + request.getParameter("userId") + " "+ request.getParameter("examId"));
		String res = request.getParameter("result");
		String examId = request.getParameter("examId");
		String id = request.getParameter("userId");
		String sql = "insert into candidate_reg values(0,?,?,?,?)";
		String date = YearMonth.now().toString();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, res);
			pst.setString(3, date);
			pst.setString(4, examId);
			pst.executeUpdate();
			
			//updateStatus
			
			Statement st = con.createStatement();
			st.execute("update exam set examstatus = 'close' where examId='"+examId+"'");
			response.sendRedirect("hpcode/index.html");
			

		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}