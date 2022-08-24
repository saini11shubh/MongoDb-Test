package com.java.mongodbtest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoTest {
	public static void main(String args[]) {
		// Creating a MongoDB client
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		
		// Connecting to the database and create Database if not exists
		MongoDatabase database = mongoClient.getDatabase("myDatabase");

		// Creating a collection
		database.createCollection("sampleCollection");
		System.out.println("Collection created successfully");

	}
}
