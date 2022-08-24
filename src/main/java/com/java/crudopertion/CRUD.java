package com.java.crudopertion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

class CRUDOpertion {
	private MongoCollection<Document> collection;
	private MongoDatabase database;

	CRUDOpertion() {
		// Creating a MongoDB client for connention
		MongoClient mongo = new MongoClient("localhost", 27017);
		// Connecting to the database if not exist in MongoDb
		database = mongo.getDatabase("CRUDOperation");
		// Creating a collection
		collection = database.getCollection("sampleCollection");
		System.out.println("-----------------------------------Create--------------------------------");
		System.out.println("Create Document successfully");
	}

	// Preparing a document and insert multiple document
	public void insertData() {
		System.out.println("-----------------------------------Insert--------------------------------");
		Document document1 = new Document("name", "Shubham").append("age", 20).append("Language", "Java");
		Document document2 = new Document("name", "Aakash").append("age", 25).append("Language", "Python");
		Document document3 = new Document("name", "Rahul").append("age", 22).append("Language", "JavaScript");
		Document document4 = new Document("name", "Sanjay").append("age", 18).append("Language", "CPP");
		List<Document> list = new ArrayList<>();
		list.add(document1);
		list.add(document2);
		list.add(document3);
		list.add(document4);

		// Inserting the document into the collection
		collection.insertMany(list);
		System.out.println("Document inserted successfully");
		this.readData();

	}

	// Retrieving the documents from myComments Collection
	public void readData() {
		System.out.println("-----------------------------------Read--------------------------------");
		FindIterable<Document> iterDoc = collection.find();
		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void update(String name, int age) {
		System.out.println("-----------------------------------Update--------------------------------");
		// Updated a document age 20 into 19
		collection.updateOne(Filters.eq("name", name), Updates.set("age", age));
		System.out.println("Document update successfully");

	}

	public void drop(String name) {
		System.out.println("-----------------------------------Drop--------------------------------");
		// Delete Sanjay name document
		collection.deleteOne(Filters.eq("name", name));
		System.out.println("Document deleted successfully");
		this.readData();
	}
}

public class CRUD {
	public static void main(String args[]) {
		CRUDOpertion crud = new CRUDOpertion();
		crud.insertData();
		crud.update("Shubham", 19);
		crud.drop("Sanjay");
	}
}
