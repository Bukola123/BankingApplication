package com.bankApp.Employees.repository;

import com.bankApp.Employees.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{

}
