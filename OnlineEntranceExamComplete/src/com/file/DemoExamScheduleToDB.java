package com.file;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.YearMonth;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoExamScheduleToDB extends HttpServlet {
	static String url = "jdbc:mysql://localhost:3306/project";
	static String usr = "root";
	static String pwd = "prabhakar";
	public static Connection con;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
//		pw.print("in db servlet");
		System.out.println("in DemoExamScheduleToDB");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pwd);
		} catch (Exception e) {
// 
			e.printStackTrace();
		}
		String subject = request.getParameter("sub");
		String examType = request.getParameter("typ");
		String noOfQuestions = request.getParameter("qus");
		String studentEmail = request.getParameter("email");
		Integer examId = (Integer) request.getAttribute("id");
		String date = YearMonth.now().toString();
		// System.out.println(subject + " " + " " + examType + " " + noOfQuestions + " "
		// + studentEmail + " "+examId);
		try {
			Statement st = con.createStatement();
			st.execute("insert into exam values(" + examId + ",'" + subject + "','" + studentEmail + "',"+ noOfQuestions + ",'" + examType + "','"+date+"','Open')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
