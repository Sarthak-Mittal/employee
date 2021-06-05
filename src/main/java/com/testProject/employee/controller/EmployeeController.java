package com.testProject.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testProject.employee.model.Employee;
import com.testProject.employee.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Employee Resources")
public class EmployeeController {

	@Autowired
	private EmployeeService employees;
	

	@ApiOperation(value="Get all the employees available")
	@GetMapping( path="/emp/all" )
	public List<Employee> getAllEmployees(){
		return employees.getAll();
		
	}
	

	@ApiOperation(value="Get particular employees details by ID")
	@GetMapping( path="/emp/{id}" )
	public Employee getEmpById(@PathVariable int id){
		return employees.getById(id);
	}
	
	@ApiOperation(value="Delete particular employees by ID")
	@DeleteMapping( path="/emp/{id}")
	public ResponseEntity<Void> deleteByID(@PathVariable int id){
		
		Employee deletedQues = employees.deleteById(id);
		if (deletedQues != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
		
	}
	
	
	@ApiOperation(value="Update particular employees detail by ID")
	@PutMapping( path="/emp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		
		Employee updatedEmp = employees.updateEmployee(emp);
		return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Add new employees")
	@PostMapping( path="/emp")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp){
		
		boolean isNewEmployeeAdded = employees.addEmployee(emp);

		if ( isNewEmployeeAdded ) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return ResponseEntity.noContent().build();
	}
	
}
