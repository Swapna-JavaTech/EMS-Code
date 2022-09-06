package com.hexaware.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.employeemanagementsystem.entity.Department;
import com.hexaware.employeemanagementsystem.exception.ResourceNotFoundException;

public interface IDepartmentService {
	public List<Department> getAllDepartments();
	public Department saveDepartment(Department dept);
	public Department updateDepartment(Department dept) throws ResourceNotFoundException;
	public Optional<Department> getDepartmentById(Long deptId);
	public void deleteDepartmentById(Long deptId);
}
