package com.testProject.employee.dao;

import java.util.List;

import com.testProject.employee.model.Employee;

public interface EmployeeDao {

	public List<Employee> getAll();
	
	public Employee getById(int id);
	
	public Employee deleteById(int id);
	
	public Employee updateEmployee(Employee emp);
	
	public boolean addEmployee(Employee emp);
	
}
