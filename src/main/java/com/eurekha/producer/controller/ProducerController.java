package com.eurekha.producer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eurekha.producer.bo.StudentDetailsBO;
import com.eurekha.producer.vo.StudentDetails;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/apps")
@Consumes("APPLICATION_JSON")
@EnableSwagger2
public class ProducerController {

	@Autowired
	StudentDetails student;

	@Autowired
	StudentDetailsBO studentBO;

	Logger logger = Logger.getLogger(ProducerController.class);

	@RequestMapping(value = "getDetails", method = RequestMethod.POST)
	public void getDetails(@RequestBody StudentDetails student) {

		logger.info("Controller: Initiated Inserting Student Details");
		logger.info("StudentID: " + student.getStudentid() + "Name: " + student.getName() + "School: "
				+ student.getSchoolname());
		
		student.setStudentid(student.getStudentid());
		student.setName(student.getName());
		student.setSchoolname(student.getSchoolname());
		
		studentBO.insertStudentDetails(student);
		logger.info("Controller: Insertion Completed");

	}
	
	@RequestMapping(value="getStudentData", method=RequestMethod.GET)
	public List<StudentDetails> getData() {
		
		List <StudentDetails> studentlist = new ArrayList<StudentDetails>();
		student.setStudentid(5123);
		student.setName("AbhiKrish");
		student.setSchoolname("SVCE");
		
		studentlist.add(student);
		return studentlist;
		
	}
	
	public Docket getSwagger() {
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.eurekha.producer")).build();
	}

}
