package com.example.Document.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.Document.model.Department;
import com.example.Document.model.Document;
import com.example.Document.repo.DocumentRepo;

@Service
public class DocumentService {
	
	@Autowired
	private  DocumentRepo dr;
	public RestTemplate rt;
	private final String url = "http://localhost:8000";
	
	public List<Document> getAllDocuments(){
		return dr.findAll();
	}
	
	public List<Document> getByTitle(String searchTerm){
		return dr.findByTitle(searchTerm);
	}
	
	public Optional<Document> getDocumentsById(Long id){
		return dr.findById(id);
	}
	
	public Optional<Document> getDocumentsByNumber(String documentNumber){
		return dr.findDocumentNumber(documentNumber);
	}
	
	public Document createDocuments(Document d){
		return dr.save(d);
	}
	
	public void deleteDocumentsById(Long id){
		dr.deleteById(id);
	}
	
	public Department fetchDepartrmentCode(String Department_code){
		String URL = url+"/"+Department_code;
		return rt.getForObject(URL, Department.class);
	}
	
	public Page<Document> getByCreationRange(LocalDate startdate ,LocalDate enddate,int page,int size){
		PageRequest pageable = PageRequest.of(page, size, Sort.by("creationDate").descending());
		return dr.findByCreationDate(startdate, enddate, pageable);
	}
	
	
	
	

}
