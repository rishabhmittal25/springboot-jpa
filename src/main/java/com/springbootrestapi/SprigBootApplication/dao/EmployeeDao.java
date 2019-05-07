package com.springbootrestapi.SprigBootApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapi.SprigBootApplication.model.Employee;
import com.springbootrestapi.SprigBootApplication.repo.EmployeeRepo;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo ;
	
	//save
	
	public Employee save(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	//find All
	public List<Employee> findAll(){
		return employeeRepo.findAll();
	}
	
	//get an employee by id
	
	public Employee findOne(Long id) {
		return employeeRepo.findOne(id);
	}
	
	//delete an emp by id
	
	public void deleteOne(Employee emp) {
		employeeRepo.delete(emp);
	}
	
	public void delete(Employee emp) {
		employeeRepo.delete(emp);
	}
}
