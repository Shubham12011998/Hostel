package com.hostel.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.api.entity.EntitlementEntity;


public interface EntitlementRepo extends JpaRepository<EntitlementEntity, String> {

	public List<EntitlementEntity> findAllByStudentId (int entitlementID);
	public EntitlementEntity findByStudentId(int entitlementID);
	
	
}
