package com.cc.processing;


import org.bson.Document;

import com.cc.bean.User;
import com.cc.utility.MongoConn;
import com.mongodb.client.MongoCollection;

public class GenerateUserClickInfo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		generateUserProfie();
	}
	public static void generateUserProfie() throws Exception{	
		String mongodbTableName="user_info";
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		Document document = new Document();
		Document type = new Document();
		type.append("News", 500).append("Paper", 300).append("Ebook", 30)
		.append("Patent", 50).append("Conference", 100);
		User user = new User();
		document.append("user_id", "wuke").append("res_type", type);
		collection.insertOne(document);
	}
}
