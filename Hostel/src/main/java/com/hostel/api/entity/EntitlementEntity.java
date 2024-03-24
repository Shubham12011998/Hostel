package com.hostel.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="entitlement")
public class EntitlementEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private  String entitlementID;
	
	//private StudentEntity studentId;
	 
	private String roomNo;
	
	private String startDate;
	
	private String endDate;
	

	public EntitlementEntity(String entitlementID, String roomNo, String startDate, String endDate) {
		super();
		this.entitlementID = entitlementID;
		this.roomNo = roomNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getEntitlementID() {
		return entitlementID;
	}

	public void setEntitlementID(String entitlementID) {
		this.entitlementID = entitlementID;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "EntitlementEntity [entitlementID=" + entitlementID + ", roomNo=" + roomNo + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
	
	
	
	
}
