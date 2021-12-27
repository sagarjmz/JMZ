package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Pojo;
import com.example.demo.service.EmpService;
import com.example.demo.service.ServiceInterface;

@RestController
public class Controller {

	@Autowired
	private ServiceInterface service;
@GetMapping("/employee")
	public List<Pojo>getPojo(){
		return this.service.getEmployee();
	}
@GetMapping("/employee/{empId}")
public Pojo getEmp(@PathVariable int empId) {
	return this.service.getEmployee(empId);
	
}
//Delete
@DeleteMapping("/employee/{empId}")
public String getEmp1(@PathVariable int empId) {
	System.out.println(empId);
	return this.service.getEmployee1(empId);
//	return ((EmpService) this.service).getEmployee1(empId);
	
	
}

@PutMapping("/employee")
public Pojo updateEmployee(@RequestBody Pojo emp) {
	return this.service.updateEmployee(emp);
	
}
@PostMapping("/employee")
public Pojo postEmployee(@RequestBody Pojo emp) {
	return this.service.postEmployee(emp);
	
}
}
