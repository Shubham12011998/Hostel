package com.hostel.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.api.entity.ReviewEntity;
;

public interface ReviewRepo  extends JpaRepository<ReviewEntity, Integer>{

	
	public List<ReviewEntity> findAllByReviewNo (int reviewNo);
	public ReviewEntity findByReviewNo(int reviewNo);
}
