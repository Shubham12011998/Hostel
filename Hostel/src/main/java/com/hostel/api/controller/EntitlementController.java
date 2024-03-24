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
import com.hostel.api.entity.EntitlementEntity;
import com.hostel.api.serviceImpl.EntitlementServiceImpl;

@RestController
@RequestMapping("/hostel/entitlement")
public class EntitlementController {

	
	@Autowired
	EntitlementServiceImpl entitlementServiceImpl ;
	
	
	
	//get all data
	
		@CrossOrigin
		@GetMapping(path="/getAllData")
		public ResponseEntity<List<EntitlementEntity>> getAllData(){
			List<EntitlementEntity> listOfAllData = entitlementServiceImpl.getAllData();
			if(listOfAllData.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(listOfAllData));
				
		}
		

		//get single data by id 
		
		@CrossOrigin
		@GetMapping(path = "/getdata/{entitlementId}")
		public ResponseEntity<EntitlementEntity> getData(@PathVariable("entitlementId") String entitlementId){
			EntitlementEntity entitlementEntity =entitlementServiceImpl.getDataById(entitlementId);
		if(entitlementEntity==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(entitlementEntity));
		}
		
		//add data 
		@CrossOrigin
		@PostMapping(path = "/adddata")
		public ResponseEntity<EntitlementEntity>   addData (@RequestBody EntitlementEntity entitlementEntity){
			EntitlementEntity entitlement= null;
			try {
				entitlement= this.entitlementServiceImpl.addData(entitlementEntity);
				System.out.println(entitlement);
				return ResponseEntity.of(Optional.of(entitlement));
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		
		//update data
		@PutMapping(path = "/update/{entitlementId}")
		public  ResponseEntity<EntitlementEntity> updateData(@RequestBody EntitlementEntity entitlementEntity , @PathVariable("entitlementId") String entitlementId){
			try {
				this.entitlementServiceImpl.updateData(entitlementEntity, entitlementId);
				return ResponseEntity.ok().body(entitlementEntity);   
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		
		//delete data
		@DeleteMapping(path = "/delete/{entitlementId}")
		public ResponseEntity<Void> deleteData(@PathVariable("entitlementId") String entitlementId){
			try {
				this.entitlementServiceImpl.deleteData(entitlementId);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
}
