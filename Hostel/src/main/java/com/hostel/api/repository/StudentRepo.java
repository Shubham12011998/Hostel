package com.hostel.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostel.api.entity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

	
	public List<StudentEntity> findAllByStudentId (int studentId);
	public StudentEntity findByStudentId(int studentId);
	public StudentEntity findByStudentEmail(String studentEmail );
	
	
}
