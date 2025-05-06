package com.example.Department.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private int Department_code;
	private String Department_name;
	private String Description;
	public Department(int id, int department_code, String department_name, String description, boolean active_status) {
		super();
		this.id = id;
		Department_code = department_code;
		Department_name = department_name;
		Description = description;
		Active_status = active_status;
	}
	private boolean Active_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepartment_code() {
		return Department_code;
	}
	public void setDepartment_code(int department_code) {
		Department_code = department_code;
	}
	public String getDepartment_name() {
		return Department_name;
	}
	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public boolean isActive_status() {
		return Active_status;
	}
	public void setActive_status(boolean active_status) {
		Active_status = active_status;
	}

}
