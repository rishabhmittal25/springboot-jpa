package com.springbootrestapi.SprigBootApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootrestapi.SprigBootApplication.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	

}
