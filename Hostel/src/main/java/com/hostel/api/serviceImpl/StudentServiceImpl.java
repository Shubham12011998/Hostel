package com.hostel.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.api.entity.StudentEntity;
import com.hostel.api.repository.StudentRepo;
import com.hostel.api.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	public StudentRepo studentRepo ;

	@Override
	public List<StudentEntity> getAllData() {
		List<StudentEntity> list = (List<StudentEntity>)this.studentRepo.findAll();
		return list;
	}
	
	

	@Override
	public StudentEntity getDataById(int studentId) {
		StudentEntity studentEntity = null;
		try {
			    studentEntity= this.studentRepo.findByStudentId(studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentEntity;
	}
	
	
	

	@Override
	public StudentEntity addData(StudentEntity studentEntity) {
		StudentEntity save = this.studentRepo.save(studentEntity);
		return save;
	}
	
	

	@Override
	public void updateData(StudentEntity studententity, int studentId) {
		studententity.setStudentId(studentId);
		studentRepo.save(studententity);
		
	}

	@Override
	public void deleteData(int studentId) {	
		studentRepo.deleteById(studentId);
		
	}

	
	
}
