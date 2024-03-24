package com.hostel.api.service;

import java.util.List;

import com.hostel.api.entity.StudentEntity;

public interface StudentService {
	
	
	    //for searching all the data
		public List<StudentEntity> getAllData();
		
		//for searching data by id
		public StudentEntity getDataById(int studentId);
		
		//for adding data 
		public StudentEntity addData (StudentEntity studentEntity);
		
		//for updating the data 
		public void updateData ( StudentEntity studententity, int  studentId);
		
		//for deleting data
		
		public void deleteData (int studentId);

}
