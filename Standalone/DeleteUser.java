import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUser {

	public static void deleteuser() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter id : ");
		int eId = sc.nextInt();


		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/core", "root", "root");
			PreparedStatement pst = con.prepareStatement("delete from user where userid = ?");
			pst.setInt(1, eId);			

			int r = pst.executeUpdate();

			if (r == 1) {
				System.out.println(" :-Deleted succesfully-: ");
			} else {
				System.out.println(" :-unsuccesful-: ");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}