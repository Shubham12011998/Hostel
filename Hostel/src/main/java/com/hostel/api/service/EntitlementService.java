package com.hostel.api.service;

import java.util.List;

import com.hostel.api.entity.EntitlementEntity;

public interface EntitlementService {

	 //for searching all the data
	public List<EntitlementEntity> getAllData();
	
	//for searching data by id
	public EntitlementEntity getDataById(int entitlementID);
	
	//for adding data 
	public EntitlementEntity addData (EntitlementEntity entitlementEntity);
	
	//for updating the data 
	public void updateData ( EntitlementEntity entitlementEntity, int  entitlementID);
	
	//for deleting data
	
	public void deleteData (int entitlementID);
}
