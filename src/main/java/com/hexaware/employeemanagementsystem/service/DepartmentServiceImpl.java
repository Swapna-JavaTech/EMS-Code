package com.hexaware.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.employeemanagementsystem.entity.Department;
import com.hexaware.employeemanagementsystem.exception.ResourceNotFoundException;
import com.hexaware.employeemanagementsystem.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
	
	@Autowired
	private DepartmentRepository deptRepository;

	@Override
	public List<Department> getAllDepartments() {
	
		return deptRepository.findAll();
	}

	@Override
	public Department saveDepartment(Department dept) {
	
		return deptRepository.save(dept);
	}

	@Override
	public Department updateDepartment(Department dept) throws ResourceNotFoundException {
	
		return deptRepository.save(dept);
	}

	@Override
	public Optional<Department> getDepartmentById(Long deptId) {
		return deptRepository.findById(deptId);
	}

	@Override
	public void deleteDepartmentById(Long deptId) {
		deptRepository.deleteById(deptId);
		
	}

}
