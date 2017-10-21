package com.sanju.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String query = "CREATE KEYSPACE IF NOT EXISTS sample "
    			+ "WITH replication={'class':'SimpleStrategy','replication_factor':1}";
    			
    			Cluster cluster = Cluster.builder().withPort(9042).addContactPoint("127.0.0.1").build();
    			Session session = cluster.connect();
    			session.execute(query);
    			
    			session.execute("USE sample");
    			System.out.println("Created");
    }
}
