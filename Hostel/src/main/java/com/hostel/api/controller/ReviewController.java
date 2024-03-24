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
import com.hostel.api.entity.ReviewEntity;
import com.hostel.api.serviceImpl.ReviewServiceImpl;

@RestController
@RequestMapping("/hostel/review")
public class ReviewController {

	@Autowired
	ReviewServiceImpl reviewServiceImpl;
	
	
	//get all data
	
		@CrossOrigin
		@GetMapping(path="/getAllData")
		public ResponseEntity<List<ReviewEntity>> getAllData(){
			List<ReviewEntity> listOfAllData = reviewServiceImpl.getAllData();
			if(listOfAllData.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(listOfAllData));
				
		}
		

		//get single data by id 
		
		@CrossOrigin
		@GetMapping(path = "/getdata/{reviewNo}")
		public ResponseEntity<ReviewEntity> getData(@PathVariable("reviewNo") int reviewNo){
			ReviewEntity reviewEntity =reviewServiceImpl.getDataById(reviewNo);
		if(reviewEntity==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(reviewEntity));
		}
		
		
		//add data 
		@CrossOrigin
		@PostMapping(path = "/adddata")
		public ResponseEntity<ReviewEntity>   addData (@RequestBody ReviewEntity reviewEntity){
			ReviewEntity review= null;
			try {
				review= this.reviewServiceImpl.addData(reviewEntity);
				System.out.println(review);
				return ResponseEntity.of(Optional.of(review));
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		//update data
		@PutMapping(path = "/update/{reviewNo}")
		public  ResponseEntity<ReviewEntity> updateData(@RequestBody ReviewEntity reviewEntity , @PathVariable("reviewNo") int reviewNo){
			try {
				this.reviewServiceImpl.updateData(reviewEntity, reviewNo);
				return ResponseEntity.ok().body(reviewEntity);   
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		
		//delete data
		@DeleteMapping(path = "/delete/{reviewNo}")
		public ResponseEntity<Void> deleteData(@PathVariable("reviewNo") int reviewNo){
			try {
				this.reviewServiceImpl.deleteData(reviewNo);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
}
		}
