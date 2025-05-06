package com.example.Department.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Department.entity.Department;
import com.example.Department.repo.DepartmentRepo;


@RestController
public class DepartmentController {
	
	@Autowired
	public DepartmentRepo dr;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllDocuments(@PathVariable int id) {
		Optional<Department> document = dr.findById(id);
		return new ResponseEntity<> (document,HttpStatus.OK);
		
	}

}
