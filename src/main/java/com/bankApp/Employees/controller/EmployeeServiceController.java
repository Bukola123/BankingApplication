package com.bankApp.Employees.controller;

import com.bankApp.Employees.exception.EmployeeNotfoundException;
import com.bankApp.Employees.model.Employee;
import com.bankApp.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeServiceController
{
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(
			@RequestHeader(name = "X-RAM-PERSIST", required = true) String headerPersist,
			@RequestBody Employee employee)
	{
		employee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(
				"Employee is created successfully with id = " + employee.getId(),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id,
			@RequestBody Employee employee)
	{
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist)
		{
			employee.setId(id);
			employeeService.updateEmployee(employee);
			return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}

	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int id)
	{
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist)
		{
			Employee employee = employeeService.getEmployee(id);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}

	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees()
	{
		List<Employee> employeeList = employeeService.getEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id)
	{
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist)
		{
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotfoundException();
		}

	}

}
