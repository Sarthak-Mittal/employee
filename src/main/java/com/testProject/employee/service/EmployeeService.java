package com.testProject.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testProject.employee.dao.EmployeeDaoImpl;
import com.testProject.employee.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDaoImpl employeeDao;

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public Employee getById(int id) {
		return employeeDao.getById(id);
	}

	public Employee deleteById(int id) {
		return employeeDao.deleteById(id);
	}

	public Employee updateEmployee(Employee emp) {
		return employeeDao.updateEmployee(emp);
	}

	public boolean addEmployee(Employee emp) {
		return employeeDao.addEmployee(emp);
	}

}
