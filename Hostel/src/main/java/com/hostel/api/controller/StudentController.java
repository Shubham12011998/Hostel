package com.hostel.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.api.entity.StudentEntity;
import com.hostel.api.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/hostel/student")
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	//get all data
	
	@CrossOrigin
	@GetMapping(path="/getAllData")
	public ResponseEntity<List<StudentEntity>> getAllData(){
		List<StudentEntity> listOfAllData = studentServiceImpl.getAllData();
		if(listOfAllData.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.of(Optional.of(listOfAllData));
			
	}
	

	//get single data by id 
	
	@CrossOrigin
	@GetMapping(path = "/getdata/{studentId}")
	public ResponseEntity<StudentEntity> getData(@PathVariable("studentId") int studentId){
		StudentEntity studentEntity =studentServiceImpl.getDataById(studentId);
	if(studentEntity==null) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.of(Optional.of(studentEntity));
	}
	
	//add data 
	@CrossOrigin
	@PostMapping(path = "/adddata")
	public ResponseEntity<StudentEntity>   addData (@RequestBody StudentEntity studentEntity){
		StudentEntity student= null;
		try {
			student= this.studentServiceImpl.addData(studentEntity);
			System.out.println(student);
			return ResponseEntity.of(Optional.of(student));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//update data
	@PutMapping(path = "/update/{studentId}")
	public  ResponseEntity<StudentEntity> updateData(@RequestBody StudentEntity studentEntity , @PathVariable("studentId") int studentId){
		try {
			this.studentServiceImpl.updateData(studentEntity, studentId);
			return ResponseEntity.ok().body(studentEntity);   //might be wrong bz of ok()
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//delete data
	@DeleteMapping(path = "/delete/{studentId}")
	public ResponseEntity<Void> deleteData(@PathVariable("studentId") int studentId){
		try {
			this.studentServiceImpl.deleteData(studentId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

}
