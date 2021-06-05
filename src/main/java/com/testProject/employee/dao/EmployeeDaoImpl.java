package com.testProject.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.testProject.employee.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	
	private static List<Employee> employees = new ArrayList<Employee>();

	static {
		employees.add(new Employee("Suresh", 25, "HR"));
		employees.add(new Employee("Ramesh", 30, "Admin"));
		employees.add(new Employee("Jane", 35, "Development"));
	}

	@Override
	public List<Employee> getAll() {
		return employees;
	}

	@Override
	public Employee getById(int id) {
		
		for (Employee emp : employees) {
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}

	@Override
	public Employee deleteById(int id) {
		Employee toBeDeleted = getById(id);
		if (toBeDeleted != null && employees.remove(toBeDeleted)) {
			return toBeDeleted;
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee modifiedEmp = getById(emp.getId());

		if (modifiedEmp != null) {

			modifiedEmp.setName(emp.getName());
			modifiedEmp.setAge(emp.getAge());
			modifiedEmp.setDepartment(emp.getDepartment());

		}
		return modifiedEmp;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		return employees.add(new Employee(emp.getName(), emp.getAge(), emp.getDepartment()));
	}
	
	
}
