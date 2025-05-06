package com.example.Document.repo;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Document.model.Document;

@Repository
public interface DocumentRepo extends JpaRepository<Document,Long> {
	
	@Query("Select d FROM Document d WHERE Lower(d.title) LIKE LOWER (CONCAT('%', :searchTerm,'%'))")
	List<Document> findByTitle (@Param("searchTerm") String searchTerm);
	
	Optional<Document> findDocumentNumber(String documentNumber);
	
	Page<Document> findByCreationDate(LocalDate startdate, LocalDate enddate, PageRequest pageable);


}
