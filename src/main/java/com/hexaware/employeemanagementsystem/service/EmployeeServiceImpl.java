package com.hexaware.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.employeemanagementsystem.entity.Employee;
import com.hexaware.employeemanagementsystem.exception.ResourceNotFoundException;
import com.hexaware.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(Long empId) {
		return employeeRepository.findById(empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) throws ResourceNotFoundException {

		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long empId) {
		employeeRepository.deleteById(empId);
		
	}
	
	

}
