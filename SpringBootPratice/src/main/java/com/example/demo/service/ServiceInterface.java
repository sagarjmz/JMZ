package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Pojo;

public interface ServiceInterface {
	public List<Pojo>getEmployee();

	public Pojo getEmployee(int empId);

	public String getEmployee1(int empId);

	public Pojo updateEmployee(Pojo emp);

	public Pojo postEmployee(Pojo emp);
}
