package com.bankApp.Employees.service.impl;

import com.bankApp.Employees.repository.EmployeeRepository;
import com.bankApp.Employees.service.EmployeeService;
import com.bankApp.Employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee)
	{
		employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployee(int id)
	{
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = optional.get();
		return employee;
	}

	@Override
	public List<Employee> getEmployees()
	{
		return (List<Employee>)employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int id)
	{
		employeeRepository.deleteById(id);
	}

	@Override
	public boolean isEmployeeExist(int id)
	{
		return employeeRepository.existsById(id);
	}
}
