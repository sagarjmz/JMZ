package com.suhel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DisplayEmployee {

public static List<Employee> list=new ArrayList<Employee>();

public static List<Employee> fetch() throws SQLException, Exception {
		
		try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver");

 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");

			String sql = "select * from empdata";
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
 
            
            
            
            while (rs.next()) {
 
                int eId = rs.getInt("eId");
                String eName = rs.getString("eName");
                int eAge = rs.getInt("eAge");
                String eDesignation = rs.getString("eDesignation");
                int eSal = rs.getInt("eSal");
                
                list.add(new Employee(rs.getInt("eId"),rs.getString("eName"),rs.getInt("eAge"),rs.getString("eDesignation"),rs.getInt("eSal")));
                
            }
            System.out.println(list);

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}