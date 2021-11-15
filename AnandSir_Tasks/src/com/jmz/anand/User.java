package com.jmz.anand;


public class User {
	@Override
	public String toString() {
		return "User [Id="+empid+",name=" + name + ",age="+age+", designation=" + designation + ", salary=" + salary + "]";
	}

	public User(int id,String name, String age,String designation, int salary) {
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

	int min = 100;  
	int max = 999; 
	private double empid1=Math.random()*(max-min+1)+min; 
	int empid=(int)empid1;
	private String name;
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
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
