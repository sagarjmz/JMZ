package com.pojo;

public class Pojo {
	private String empid;
	private String empname;
	private int empage;
	private String designation;
	private int empsalary;



	
	public int getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(int empsalary) {
		this.empsalary = empsalary;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpage() {
		return empage;
	}
	
	
	public Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pojo(String empid, String empname, int empage, String designation, int empsalary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empage = empage;
		this.designation = designation;
		this.empsalary=empsalary;
	}
	public void setEmpage(int empage) {
		this.empage = empage;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
