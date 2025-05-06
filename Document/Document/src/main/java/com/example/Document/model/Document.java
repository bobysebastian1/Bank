package com.example.Document.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Document {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String documentNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public Department getOwnerDepartment() {
		return ownerDepartment;
	}
	public void setOwnerDepartment(Department ownerDepartment) {
		this.ownerDepartment = ownerDepartment;
	}
	public String getDocumenType() {
		return documenType;
	}
	public void setDocumenType(String documenType) {
		this.documenType = documenType;
	}
	public String getSecurityClassification() {
		return SecurityClassification;
	}
	public void setSecurityClassification(String securityClassification) {
		SecurityClassification = securityClassification;
	}
	public String getDigitalfilelocation() {
		return Digitalfilelocation;
	}
	public void setDigitalfilelocation(String digitalfilelocation) {
		Digitalfilelocation = digitalfilelocation;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	@Column(nullable = false)
	private String title;
	private String description;
	private LocalDate creationDate;
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Department ownerDepartment ;
	public Document(Long id, String documentNumber, String title, String description, LocalDate creationDate,
			Department ownerDepartment, String documenType, String securityClassification, String digitalfilelocation,
			String version) {
		super();
		this.id = id;
		this.documentNumber = documentNumber;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.ownerDepartment = ownerDepartment;
		this.documenType = documenType;
		SecurityClassification = securityClassification;
		Digitalfilelocation = digitalfilelocation;
		Version = version;
	}
	private String documenType; 
	private String SecurityClassification; 
	private String Digitalfilelocation; 
	private String Version; 

}
