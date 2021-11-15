package Java_Classes;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MainClass {
	
	public static void main(String [] args) throws Exception
	{
		 int n = 0;
		Scanner sc = new Scanner(System.in); 
		String value ;
	
		while( n==0)
		{
			
			System.out.println("choose 1)create 2)display 3)raise_Salary 4)Exit");
			value = sc.next();
			if(value.equals("1"))
			{
				CreateUser.createUser();	
			}
			else if(value.equals("2"))
		    {
				DisplayUser.displayUser();
		    }
			else if(value.equals("3"))
		    {
				RaiseSalary.raiseSalary();
		    }
			else if(value.equals("4"))
		    {
				n++;
		    }
			else {
				System.out.println("enter proper input");
			}
		}
		System.out.println("Program Terminated");
		
	}

}
