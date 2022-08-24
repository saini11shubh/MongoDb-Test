package com.java.retrievalldocuments;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RetrievAllDocuments {
	public static void main( String args[] ) {
	      //Creating a MongoDB client for connention
	      MongoClient mongo = new MongoClient( "localhost" , 27017 );
	      
	      //Connecting to the database
	      MongoDatabase database = mongo.getDatabase("ShubhamData");
	      
	      //Creating a collection object
	      MongoCollection<Document> collection = database.getCollection("myComments");
	      
	      //Retrieving the documents from myComments Collection
	      FindIterable<Document> iterDoc = collection.find();
	      Iterator it = iterDoc.iterator();
	      while (it.hasNext()) {
	         System.out.println(it.next());
	      }
	   }
}
