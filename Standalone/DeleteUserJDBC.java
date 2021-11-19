import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteUserJDBC {
	public static void deleteUser() {
		// TODO Auto-generated method stub
		
	}
	public static void deleteUserJDBC(int id) throws SQLException {
		try {
//			Scanner sc =new Scanner("System.in");
			//System.out.println("enter id");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("connection established");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/core","root", "root");
			 Statement st=con.createStatement();
			
			 String query1 = "Delete from user where userid="+id;
			 st.executeUpdate(query1);
			 System.out.println("rec del");
			 //ResultSet rs=st.executeQuery(query1);
	/*		 while(rs.next()) {
				 System.out.println(rs.getInt("id"));
				 System.out.println(rs.getString("first_name"));
				 System.out.println(rs.getString("last_name"));
				 System.out.println(rs.getInt("username"));
				 System.out.println(rs.getInt("password"));
				 System.out.println(rs.getString("address"));
				 System.out.println(rs.getLong("contact"));*/
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}

