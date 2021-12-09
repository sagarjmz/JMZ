package com.jmz.anand;

import java.time.YearMonth;

public class User {
	@Override
	public String toString() {
		return "User [Id="+empid+",name=" + name + ",age="+age+", designation=" + designation + ", salary=" + salary + "]";
	}

	public User(String id,String name, String age,String designation, int salary) {
		super();
		this.empid=id;
		this.name = name;
		this.age=age;
		this.designation = designation;
		this.salary = salary;
	}
	public User(String name, String age,String designation, int salary) {
		super();
		
		this.name = name;
		this.age=age;
		this.designation = designation;
		this.salary = salary;
	}
	public User(String name, String age) {
		super();
		
		this.name = name;
		this.age=age;
//		this.designation = designation;
//		this.salary = salary;
	}
	public User(String designation, int salary) {
		super();
		this.designation = designation;
		this.salary = salary;
	}
	User() {

	}

//	public double getEmpid1() {
//		return empid1;
//	}
//
//	public void setEmpid1(double empid1) {
//		this.empid1 = empid1;
//	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	private String empid;
	
	private String name;
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	private String designation;
	private int salary;
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String age;

}
