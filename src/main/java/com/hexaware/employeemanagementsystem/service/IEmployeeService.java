package com.hexaware.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;



import com.hexaware.employeemanagementsystem.entity.Employee;
import com.hexaware.employeemanagementsystem.exception.ResourceNotFoundException;

public interface IEmployeeService {

	public List<Employee> getAllEmployees();
	public Employee saveEmployee(Employee employee);
	public Employee updateEmployee(Employee employee) throws ResourceNotFoundException;
	public Optional<Employee> getEmployeeById(Long empId);
	public void deleteEmployeeById(Long empId);
}
