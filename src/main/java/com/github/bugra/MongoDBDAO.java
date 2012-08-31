package com.github.bugra;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongoDBDAO implements DAO{
	
	// Parse the object into its fields to put in a basic MongoDB object
	private BasicDBObject toBasicDBObject(Receipt receipt) {
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("id", receipt.getId());
		basicDBObject.put("name", receipt.getName());
		basicDBObject.put("text", receipt.getText());
		return basicDBObject;
	}
	public void create(Receipt receipt) {
		try{
				BasicDBObject basicDBObject = toBasicDBObject(receipt);
				DB db = MongoDBCreater.getDB("MyDB");
				DBCollection collection = db.getCollection("MyCollection");
				collection.save(basicDBObject);
			}
		catch (Exception e){
				e.printStackTrace();
			}
	}

	public void update(Receipt receipt) {
		try{
				BasicDBObject searchQuery = new BasicDBObject();
				searchQuery.put("id", receipt.getId());
				BasicDBObject basicDBObject = toBasicDBObject(receipt);
				DB db = MongoDBCreater.getDB("MyDB");
				DBCollection collection = db.getCollection("MyCollection");
				collection.update(searchQuery, basicDBObject);
			}
		catch (Exception e){
				e.printStackTrace();
			}
				
	}
	// same method as insert except save() is replaced by remove()
	public void delete(Receipt receipt) {
		try{
				BasicDBObject basicDBObject = toBasicDBObject(receipt);
				DB db = MongoDBCreater.getDB("MyDB");
				DBCollection collection = db.getCollection("MyCollection");
				collection.remove(basicDBObject);
		}
		catch (Exception e){
				e.printStackTrace();
		}
	}
	// For debug purposes
	public void printAll(Receipt receipt){
		try{
				DB db = MongoDBCreater.getDB("MyDB");
				DBCollection collection = db.getCollection("MyCollection");
				DBCursor cursor = collection.find();
				while(cursor.hasNext()){
					System.out.println(cursor.next());
				}
		}
		catch (Exception e){
				e.printStackTrace();
		}
	}
}
