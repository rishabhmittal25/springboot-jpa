package com.springbootrestapi.SprigBootApplication.controller;

import java.util.List;   

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.SprigBootApplication.dao.EmployeeDao;

import com.springbootrestapi.SprigBootApplication.model.Employee;

 
@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeDao empDao;
	
	//save emp into db
	@PostMapping("/employees1")
	public Employee createEmp(@Valid @RequestBody Employee emp) {
		return empDao.save(emp);
	}
	
	@GetMapping("/employees")
	public List<Employee> allEmp(){
		//List<Employee> ll=empDao.findAll();
		return empDao.findAll();
	}

	// get emp by particular ID
	@GetMapping("/notes{id}")
	public ResponseEntity<Employee> getById(@PathVariable(value="id") Long empId){
		
		Employee emp =empDao.findOne(empId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(emp);
		}
	}
	
	
	// update an emp by id
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empId, @Valid @RequestBody Employee empDetails){
		
		Employee emp = empDao.findOne(empId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}else {
			emp.setName(empDetails.getName());
			emp.setDesignation(empDetails.getDesignation());
			emp.setExpertise(empDetails.getExpertise());
			Employee updateEmp = empDao.save(emp);
			return ResponseEntity.ok().body(updateEmp);
		}
	}
	
	/*Delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=empDao.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		empDao.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	
}
