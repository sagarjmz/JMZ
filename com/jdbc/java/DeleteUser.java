package com.jdbc.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUser 
{
	static Connection con;
	static Statement st ; 
public static void deleteUser(int id) throws SQLException
{
	 con = UserConnection.con;
	boolean res =  UserConnection.st.execute("delete from user where userId ="+id);
	if(res != true)
	{
		System.out.println("deletion sucessfull");
	}
	else
	{
		System.out.println("wrong id");
	}
}
}
