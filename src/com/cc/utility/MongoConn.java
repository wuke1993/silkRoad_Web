package com.cc.utility;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConn {
	/**
	 * Authorized connect to MongoDB
	 * @param mongodbTableName
	 * @return
	 */
    public MongoCollection<Document> connWithAuth(String mongodbTableName){
    	ServerAddress ip = new ServerAddress("localhost",27017);
    	String database = "silkRoad";
    	String userName = "wuke";
    	String password = "mongodb19930728.";
    	MongoCredential credential = MongoCredential.createCredential(userName, database, password.toCharArray());
        
    	try{
           
			MongoClient mongoClient = new MongoClient(ip, Arrays.asList(credential));
            MongoDatabase mongoDatabase = mongoClient.getDatabase("silkRoad");
            
            System.out.println("Successfully connect to MongoDB!");
            
            MongoCollection<Document> collection = mongoDatabase.getCollection(mongodbTableName);
            return collection;

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("***************");
            return null;
        }
    }
    
    /**
     * Unauthorized connect to MongoDB
     * @param mongoCollectionName
     * @return
     */
	public static MongoCollection<Document> conn(String mongoCollectionName) {
		String databaseName = "silkRoad";
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			
			MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
			System.out.println("Successfully connect to mongodb database " + databaseName + "!");
			
			MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(mongoCollectionName);
			System.out.println("Successfully get collection " + mongoCollectionName + "!");
			
			return mongoCollection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}