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

import com.hexaware.employeemanagementsystem.entity.Department;
import com.hexaware.employeemanagementsystem.exception.ResourceNotFoundException;
import com.hexaware.employeemanagementsystem.service.IDepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private IDepartmentService deptService;
	
	@GetMapping("/listdepartments")
	public List<Department> getAllDepartments(){
		return deptService.getAllDepartments();
	}
	
	@PostMapping("/savedepartment")
	public Department saveDepartment(@RequestBody Department department) {
		return deptService.saveDepartment(department);
	}
	
	@PutMapping("/updatedepartment/{deptid}")
	public Department updateDepartment(@RequestBody Department newDepartment,@PathVariable("deptid") Long deptId) throws ResourceNotFoundException {
		Department dept =  deptService.getDepartmentById(deptId)
				.orElseThrow(() -> new ResourceNotFoundException("department not exists with id" +deptId));

		dept.setDeptName(newDepartment.getDeptName());
		return deptService.updateDepartment(dept);
		
	}
	
	@GetMapping("/finddepartment/{deptid}")
	public Department getDepartmentById(@PathVariable("deptid") Long deptId){
		return deptService.getDepartmentById(deptId).get();
	}
	
	@DeleteMapping("/deletedepartment/{deptid}")
	public void deleteEmployeeById(@PathVariable("deptid") Long deptId){
		deptService.deleteDepartmentById(deptId);
	}


}
