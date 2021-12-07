package com.TO;

public class Employee {
	
	private String empId;
	private String name;
	private int age;
	private String designation;
	private int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", designation=" + designation
				+ ", salary=" + salary + "]";
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(String empId, String name, int age, String designation, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Employee(String empId) {
		super();
		this.empId = empId;
	}
	
	public Employee(String empId, int salary) {
		super();
		this.empId = empId;
		this.salary = salary;
	}

}
