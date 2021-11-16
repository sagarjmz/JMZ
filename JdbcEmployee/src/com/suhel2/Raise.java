package com.suhel2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Raise {
	static int empId;
	static String empName;
	static int empSalary;

	public static void raise() {
		List l1 = DisplayEmployee.list;
		
		if (l1.size() == 0) {
			System.out.println(" :-no data found-: ");
		} else {
			Iterator l;
			l = DisplayEmployee.list.iterator();
			while (l.hasNext()) {
				Employee user = (Employee) l.next();
				System.out.println(" ENTER EMPLOYEE ID : ");
				Scanner sc1 = new Scanner(System.in);
				empId = sc1.nextInt();
				
				System.out.println(" ENTER EMPLOYEE NAME : ");
				Scanner sc2 = new Scanner(System.in);
				
				empName = sc2.nextLine();
				
				
				  String uidcheck = "^[0-9]+$";
				  Pattern p1 = Pattern.compile(uidcheck);
				  Matcher m1 = p1.matcher(String.valueOf(empId));
				  
				  String namecheck = "^[A-Za-z\\s]+$";
				  Pattern p = Pattern.compile(namecheck);
				  
				  Matcher m = p.matcher(empName);
				 
				if (m.matches() && m1.matches()) {
					if (empId == Employee.geteId() && empName.equals(Employee.geteName())) {
						System.out.println(" ENTER PERCENTAGE TO INCREASE : ");
						Scanner sc = new Scanner(System.in);
						int z = sc.nextInt();
						empSalary = Employee.geteSal() + ((Employee.geteSal() * z) / 100 );
						Employee.seteSal(empSalary);
						//System.out.println(empSalary);
						OperationRaise.operationRaise();
						EmployeeMain.employeeMain();
					} else {
						System.out.println(" :-Enter valid id and valid Name-: ");
					}
				} else {
					System.out.println(" :-invalid input-: ");
				}

			}
		}
	}
}

