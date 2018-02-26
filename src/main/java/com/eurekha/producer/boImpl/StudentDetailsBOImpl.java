package com.eurekha.producer.boImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.eurekha.producer.bo.StudentDetailsBO;
import com.eurekha.producer.cassandraconfig.CassandraConnector;
import com.eurekha.producer.vo.StudentDetails;

@Service
public class StudentDetailsBOImpl implements StudentDetailsBO {

	Logger logger = Logger.getLogger(StudentDetailsBOImpl.class);

	@Autowired
	CassandraConnector cassandraconnect;

	@Override
	public void insertStudentDetails(StudentDetails student) {

		String Node = "localhost";
		int Port = 9042;
		//String keyspace = "newspace";

		logger.info("BOImpl: Initialized Cassandra Connection");
		
		cassandraconnect.Connection(Node, Port);

		logger.info("BOImpl: Started Inserting data");
		
		final String insertStudentData ="INSERT INTO newspace.student_details(studentid, name, schoolname) "
				+ " values(" +student.getStudentid()+" ,'"+student.getName()+"','"+student.getSchoolname()+"');";
		
		
		cassandraconnect.getSession().execute(insertStudentData);
		
		logger.info("BOImpl: Completed Inserting data");

	}

}
