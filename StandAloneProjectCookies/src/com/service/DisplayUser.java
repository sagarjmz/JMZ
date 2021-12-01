package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.java.User;
import com.jdbc.java.Connections;
import com.jdbc.java.UserConnection;


public class DisplayUser extends HttpServlet {
	static Connection con = Connections.con;
	static PreparedStatement pst;
	static PreparedStatement pst1;
	static Statement st;
	static Statement st1;
	static List<User> list = new LinkedList<User>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		list.clear();
		try {
			st = con.createStatement();
			st1 = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Core.userData");

			while (rs.next()) {

				ResultSet rs1 = st1
						.executeQuery("select * from Core.designation where userId ='" + rs.getString(1) + "'");
				rs1.next();

				list.add(new User(rs.getString("userName"), rs1.getString("Designation"), rs1.getLong("Salary"),
						rs.getString("userId"), rs.getInt("userAge")));

			}
			PrintWriter pw = response.getWriter();
			pw.print("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<style>\n" + "#customers {\n"
					+ "  font-family: Arial, Helvetica, sans-serif;\n" + "  border-collapse: collapse;\n"
					+ "  width: 100%;\n" + "}\n" + "\n" + "#customers td, #customers th {\n"
					+ "  border: 1px solid #ddd;\n" + "  padding: 8px;\n" + "}\n" + "\n"
					+ "#customers tr:nth-child(even){background-color: #f2f2f2;}\n" + "\n"
					+ "#customers tr:hover {background-color: #ddd;}\n" + "\n" + "#customers th {\n"
					+ "  padding-top: 12px;\n" + "  padding-bottom: 12px;\n" + "  text-align: left;\n"
					+ "  background-color: #04AA6D;\n" + "  color: white;\n" + "}\n" + "</style>\n" + "</head>\n"
					+ "<body>\n" + "\n" + "<h1>User Record Table</h1>\n" + "\n" + "<table id=\"customers\">\n"
					+ "  <tr>\n" + "      <th>Id</th>\n" + "    <th>Name</th>\n" + "    <th>Age</th>\n"
					+ "    <th>Designation</th>\n" + "        <th>Salary</th>\n" + "  </tr>\n" + "  \n");
			Iterator i = list.iterator();
			while (i.hasNext()) {
				User user = (User) i.next();
				pw.print("  <tr>\n" + "    <td>" + user.getUid() + "</td>\n" + "    <td>" + user.getName() + "</td>\n"
						+ "    <td>" + user.getAge() + "</td>\n" + "     <td>" + user.getDesignation() + "</td>\n"
						+ "    <td>" + user.getSalary() + "</td>\n" + "  </tr>\n");
			}
			pw.print(" \n" + "</table>\n" + "\n" + "</body>\n" + "</html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void listClear() {
		list.clear();
	}

}
