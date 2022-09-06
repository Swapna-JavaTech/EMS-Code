package com.hexaware.employeemanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "emp_data")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_sal")
	private float empSal;
	
	@Column(name = "emp_location")
	private String empLoc;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, float empSal, String empLoc) {
		super();
		this.empName = empName;
		this.empSal = empSal;
		this.empLoc = empLoc;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}

	public String getEmpLoc() {
		return empLoc;
	}

	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empLoc=" + empLoc + "]";
	}
	
}
