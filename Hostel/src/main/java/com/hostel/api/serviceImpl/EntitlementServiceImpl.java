package com.hostel.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.api.entity.EntitlementEntity;
import com.hostel.api.repository.EntitlementRepo;
import com.hostel.api.service.EntitlementService;

@Service
public class EntitlementServiceImpl implements EntitlementService  {

	@Autowired
	public EntitlementRepo entitlementRepo;
	

	@Override
	public List<EntitlementEntity> getAllData() {
		List<EntitlementEntity> list = (List<EntitlementEntity>)this.entitlementRepo.findAll();
		return list;
	}
	
	

	@Override
	public EntitlementEntity getDataById(String entitlementID) {
		EntitlementEntity entitlementEntity = null;
		try {
			entitlementEntity= this.entitlementRepo.findByEntitlementID(entitlementID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entitlementEntity;
	}

	
	
	@Override
	public EntitlementEntity addData(EntitlementEntity entitlementEntity) {
		EntitlementEntity save = this.entitlementRepo.save(entitlementEntity);
		return save;
	}
	
	

	@Override
	public void updateData(EntitlementEntity entitlementEntity, String entitlementID) {
		entitlementEntity.setEntitlementID(entitlementID);
		entitlementRepo.save(entitlementEntity);
		
	}
	
	

	@Override
	public void deleteData(String entitlementID) {
		entitlementRepo.deleteById(entitlementID);
		
	}
	
	
}
