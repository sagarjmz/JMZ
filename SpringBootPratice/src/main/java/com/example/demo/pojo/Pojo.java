package com.example.demo.pojo;

public class Pojo {
	private int empId;
	private String empName;
	private int empAge;
	private String empDesig;
	private float empSalary;
	public Pojo(int empId, String empName, int empAge, String empDesig, float empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empDesig = empDesig;
		this.empSalary = empSalary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpDesig() {
		return empDesig;
	}
	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	

}


