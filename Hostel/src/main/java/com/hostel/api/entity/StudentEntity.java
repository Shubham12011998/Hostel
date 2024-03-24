package com.hostel.api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Student")
public class StudentEntity {
	

	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO )

	private int studentId ;
	private String studntName;
	private String studentDOB;
	private String studentEmail;
	private Long studentContactNo;
	private String studentAdmisiionDate ;
	
	
	
	
	
	public StudentEntity(int studentId, String studntName, String studentDOB, String studentEmail,
			Long studentContactNo, String studentAdmisiionDate) {
		super();
		this.studentId = studentId;
		this.studntName = studntName;
		this.studentDOB = studentDOB;
		this.studentEmail = studentEmail;
		this.studentContactNo = studentContactNo;
		this.studentAdmisiionDate = studentAdmisiionDate;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudntName() {
		return studntName;
	}
	public void setStudntName(String studntName) {
		this.studntName = studntName;
	}
	public String getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public Long getStudentContactNo() {
		return studentContactNo;
	}
	public void setStudentContactNo(Long studentContactNo) {
		this.studentContactNo = studentContactNo;
	}
	public String getStudentAdmisiionDate() {
		return studentAdmisiionDate;
	}
	public void setStudentAdmisiionDate(String studentAdmisiionDate) {
		this.studentAdmisiionDate = studentAdmisiionDate;
	}
	
	
	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studntName=" + studntName + ", studentDOB=" + studentDOB
				+ ", studentEmail=" + studentEmail + ", studentContactNo=" + studentContactNo
				+ ", studentAdmisiionDate=" + studentAdmisiionDate + "]";
	}

}
