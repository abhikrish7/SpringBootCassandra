package com.eurekha.producer.cassandraconfig;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Component
public class CassandraConnector {

	private Cluster cluster;
	private Session session;
	Logger logger = Logger.getLogger(CassandraConnector.class);

	public void Connection(String node, int port) {
		
		logger.info("Started connecting to Cassandra");
		this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
		session = cluster.connect();
		logger.info("Established Cassandra Connection");
	}

	public Session getSession() {
		return this.session;
	}

	public void close() {

		logger.info("Query Executed");
		cluster.close();
	}

}
