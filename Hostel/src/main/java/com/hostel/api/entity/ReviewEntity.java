package com.hostel.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReviewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int reviewNo ;
	
	//private StudentEntity studentId ;
	
	private int rating ;
	
	private String review ;
	
	

	public ReviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewEntity(int reviewNo, int rating, String review) {
		super();
		this.reviewNo = reviewNo;
		this.rating = rating;
		this.review = review;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "ReviewEntity [reviewNo=" + reviewNo + ", rating=" + rating + ", review=" + review + "]";
	}
	

	  
}
