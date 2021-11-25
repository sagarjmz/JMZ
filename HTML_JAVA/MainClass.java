package com.ONE;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.setContentType("text/html");
			Random rand = new Random();
			int id = rand.nextInt(99);
			PrintWriter pw = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hpdata", "root", "tiger");
			PreparedStatement pst = con.prepareStatement("insert into signup values(?,?,?)");
			Statement st = con.createStatement();
			pst.setInt(1, id);
			pst.setString(2, request.getParameter("id"));
			pst.setString(3, request.getParameter("pwd"));
			int r = pst.executeUpdate();
			if (r == 1) {
				response.setContentType("text/html");
				pw.println(
						"<html><head><center></head><body style=\"background-color:green\"><h1>YOU ARE WELCOME</h1></body></html>");
			} else {
				pw.println(
						"<html><head><center></head><body style=\"background-color: red\"><h1>INVALID USER</h1></body></html>");
			}

		} catch (Exception e) {

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hpdata", "root", "tiger");
			Statement st = con.createStatement();
			String nm = request.getParameter("id1");
			String pwd = request.getParameter("pwd1");
			ResultSet rs = st.executeQuery("SELECT * FROM signup where name = '" + nm + "' and pwd = '" + pwd + "'");

			if (rs.next()) {
				out.println(
						"<html><head><center></head><body style=\"background-color:green \"><h1>YOU ARE WELCOME</h1></body></html>");
			} else {

				out.println(
						"<html><head><center></head><body style=\"background-color:red \"><h1>INVALID USER</h1></body></html>");
			}

		} catch (Exception e) {

		}

	}
}
