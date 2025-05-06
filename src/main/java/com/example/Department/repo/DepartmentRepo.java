package com.example.Department.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Department.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {

}
