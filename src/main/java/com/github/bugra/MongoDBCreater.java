package com.github.bugra;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * @author Bugra
 *
 */
public class MongoDBCreater {

	private static Mongo mongo = null;
	/* One thread is executing a synchronized method for an object, all other threads 
	 that invoke synchronized methods for the same object block (suspend execution)
	  until the first thread is done with the object. */
	public static synchronized DB getDB(String dbName) throws Exception {
		if(mongo == null) {
			mongo = new Mongo();
		} 
		return mongo.getDB(dbName);
	}
}