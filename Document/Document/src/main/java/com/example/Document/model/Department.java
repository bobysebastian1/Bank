package com.example.Document.model;

public class Department {
	private int id;
	public Department(int id, int department_code, String department_name, String description) {
		super();
		this.id = id;
		Department_code = department_code;
		Department_name = department_name;
		Description = description;
	}
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
	private int Department_code;
	private String Department_name;
	private String Description;
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
}
