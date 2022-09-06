package com.hexaware.employeemanagementsystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.employeemanagementsystem.entity.Employee;
import com.hexaware.employeemanagementsystem.exception.ResourceNotFoundException;
import com.hexaware.employeemanagementsystem.service.IEmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService empService;
	
	@GetMapping("/listemployees")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@PostMapping("/saveemployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return empService.saveEmployee(employee);
	}
	
	@PutMapping("/updateemployee/{eid}")
	public Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable("eid") Long empId) throws ResourceNotFoundException {
		Employee emp =  empService.getEmployeeById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("employee not exists with id" +empId));

		emp.setEmpName(newEmployee.getEmpName());
		emp.setEmpSal(newEmployee.getEmpSal());
		emp.setEmpLoc(newEmployee.getEmpLoc());
		return empService.updateEmployee(emp);
		
	}
	
	@GetMapping("/findemployee/{eid}")
	public Employee getEmployeeById(@PathVariable("eid") Long empId){
		return empService.getEmployeeById(empId).get();
	}
	
	@DeleteMapping("/deleteemployee/{eid}")
	public void deleteEmployeeById(@PathVariable("eid") Long empId){
		 empService.deleteEmployeeById(empId);
	}

}
