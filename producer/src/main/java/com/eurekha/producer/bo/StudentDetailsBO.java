package com.eurekha.producer.bo;

import org.springframework.stereotype.Service;

import com.eurekha.producer.vo.StudentDetails;

@Service
public interface StudentDetailsBO {
	
	public void insertStudentDetails(StudentDetails student);

}
