package com.pojo;

public class Pojo {
private String id;
private String uname;
private int age;
private String desig;
private int salary;
public Pojo(String id, String uname, int age, String desig, int salary) {
	super();
	this.id = id;
	this.uname = uname;
	this.age = age;
	this.desig = desig;
	this.salary = salary;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getDesig() {
	return desig;
}
public void setDesig(String desig) {
	this.desig = desig;
}

public void setSalary(int salary) {
	this.salary = salary;
}
public int getSalary() {
	// TODO Auto-generated method stub
	return salary;
}
}
