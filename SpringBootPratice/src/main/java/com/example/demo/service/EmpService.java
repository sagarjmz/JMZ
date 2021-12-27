package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Pojo;

@Service
public class EmpService implements ServiceInterface{
	List<Pojo> list;
	
	public EmpService() {
		list=new ArrayList<Pojo>();
		list.add(new Pojo(1,"uday",26,"tester",2000));
		list.add(new Pojo(2,"uday",26,"tester",100));
	}
	@Override
	public List<Pojo> getEmployee() {
		
		return list;
	}
	@Override
	public Pojo getEmployee(int empId) {
		Pojo p= null;
		for(Pojo po:list) {
			if(po.getEmpId()==empId) {
				p=po;
				break;
			}
		}
		return p;
	}
	
	public String getEmployee1(int empId) {
		// TODO Auto-generated method stub
		
		System.out.println();
		
		for(Pojo p2:list) {
			if(p2.getEmpId() == empId) 
			{
				list.remove(p2);
				//break;
				return "done";
			}
		}
		return "not done";
	}
	@Override
	public Pojo updateEmployee(Pojo emp) {
		
			for(Pojo ppo:list) {
				if(ppo.getEmpId()==emp.getEmpId()) {
					ppo.setEmpName(emp.getEmpName());
					ppo.setEmpAge(emp.getEmpAge());
					ppo.setEmpDesig(emp.getEmpDesig());
					ppo.setEmpSalary(emp.getEmpSalary());
					
				}
			}
			return emp;
		}
	@Override
	public Pojo postEmployee(Pojo emp) {
		list.add(emp);
		return emp;
	}

	
	}
	


