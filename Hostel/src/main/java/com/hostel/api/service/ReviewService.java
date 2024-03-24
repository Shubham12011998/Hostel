package com.hostel.api.service;

import java.util.List;

import com.hostel.api.entity.ReviewEntity;


public interface ReviewService {

	   //for searching all the data
			public List<ReviewEntity> getAllData();
			
			//for searching data by id
			public ReviewEntity getDataById(int reviewNo);
			
			//for adding data 
			public ReviewEntity addData (ReviewEntity reviewEntity);
			
			//for updating the data 
			public void updateData ( ReviewEntity reviewEntity, int  reviewNo);
			
			//for deleting data
			
			public void deleteData (int reviewNo);
	
	
	
}
