package com.example.Document.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Document.model.Department;
import com.example.Document.model.Document;
import com.example.Document.service.DocumentService;

@RestController
public class DocumentController {
	
	@Autowired
	public DocumentService ds;
	
	@GetMapping
	public ResponseEntity<List<Document>> getAllDocuments() {
		List<Document> document = ds.getAllDocuments();
		return new ResponseEntity<> (document,HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDocumentsById(@PathVariable Long id) {
		Optional<Document> document = ds.getDocumentsById(id);
		if(document.isPresent()) {
			return new ResponseEntity<> (document,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<> ("Not Found",HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/search/title")
	public ResponseEntity<?> findByTitle(@RequestParam String query) {
		List<Document> document = ds.getByTitle(query);
			return new ResponseEntity<> (document,HttpStatus.OK);	
	}
	
	@GetMapping("/search/DepCode")
	public ResponseEntity<?> getByDepartmentNumber(@PathVariable String Department_code) {
		Department document = ds.fetchDepartrmentCode(Department_code);
		if(document.isPresent()) {
			return new ResponseEntity<> (document.getDepartment_name(),HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<> ("Department Code Not Found",HttpStatus.NOT_FOUND);	
		}	}
	
	@GetMapping("/search/documentNumber")
	public ResponseEntity<?> findByDocumentNumber(@PathVariable String documentNumber) {
		Optional<Document> document = ds.getDocumentsByNumber(documentNumber);
		if(document.isPresent()) {
			return new ResponseEntity<> (document,HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<> ("Document Number Not Found",HttpStatus.NOT_FOUND);	
		}
	}
	
	@PostMapping
	public ResponseEntity<Document> craeteDocuments(@RequestBody Document doc) {
		Document createdocument = ds.createDocuments(doc);
		return new ResponseEntity<> (createdocument,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> DeleteById(@PathVariable Long id) {
		Optional<Document> document = ds.getDocumentsById(id);
		if(document.isPresent()) {
			ds.deleteDocumentsById(id);
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
		else {
			return new ResponseEntity<> ("Not Found",HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/search/date")
	public ResponseEntity<?> getByCreationRange(@RequestParam("startdate") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) 
	LocalDate startdate ,@RequestParam("enddate ") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate enddate,
	@RequestParam(defaultValue ="0") int page,
	@RequestParam(defaultValue ="0") int size){
		Page<Document> document = ds.getByCreationRange(startdate, enddate, page, size);
		return new ResponseEntity<> (document,HttpStatus.OK);
	}

}
