package com.hostel.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.api.entity.ReviewEntity;
import com.hostel.api.repository.ReviewRepo;
import com.hostel.api.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewRepo reviewRepo ;

	@Override
	public List<ReviewEntity> getAllData() {
		List<ReviewEntity> list = (List<ReviewEntity>)this.reviewRepo.findAll();
		return list;
	}

	
	@Override
	public ReviewEntity getDataById(int reviewNo) {
		ReviewEntity reviewEntity = null;
		try {
			reviewEntity= this.reviewRepo.findByReviewNo(reviewNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewEntity;
	}

	@Override
	public ReviewEntity addData(ReviewEntity reviewEntity) {
		ReviewEntity save = this.reviewRepo.save(reviewEntity);
		return save;
	}

	@Override
	public void updateData(ReviewEntity reviewEntity, int reviewNo) {
		reviewEntity.setReviewNo(reviewNo);
		reviewRepo.save(reviewEntity);
		
		
	}

	@Override
	public void deleteData(int reviewNo) {
		reviewRepo.deleteById(reviewNo);
		
	}

}
