package com.jmz.anand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class MainClass {
	
	public static int n;

	public static void main(String [] args) throws Exception
	{
		Random r=new Random();
	
		int n = 0;
		Scanner sc = new Scanner(System.in); 
		String value ;
		while( n==0)
		{
			System.out.println("choose 1)create 2)display 3)raise salary 4)exit");
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
				System.out.println("terminated");
				n++;
		    }
			else {
				System.out.println("enter proper input");
			}
		}
		sc.close();
	}

}