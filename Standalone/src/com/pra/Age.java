package com.pra;

import java.util.Scanner;

public class Age {

	static void salary() {
		int ag=0;
		int a;
		Scanner sc=new Scanner(System.in);
		while(ag==0) {
			System.out.println("enter the age");
			String age=sc.nextLine();
			if((a=Integer.parseInt(age))>60) {
				System.out.println("enter the age between 18-60");
				ag=0;
			}
			else if((a=Integer.parseInt(age))<18) {
				System.out.println("ener age between 18-60");
				ag=0;
			}
			else {
				ag++;
			}
		}
		
	}
	public static void main(String[] args) {
		Age a=new Age();
		a.salary();
	}
	}