package com.cc.processing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bson.Document;

import com.cc.bean.Ebook;
import com.cc.bean.Patent;
import com.cc.utility.MongoConn;
import com.cc.utility.MysqlConn;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

public class GenerateHotEbook {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
generateEbook();
	}
	
	public static void generateEbook() throws Exception{
		String mongodbTableName="res_ebook_info";
		String res_id1 ="001463968219613063bd08465c94e4694ee53a9bf51a217000";
		MysqlConn mysqlConn = new MysqlConn();
		Connection sqlconn = mysqlConn.createConnPool();
		PreparedStatement pstmt = sqlconn
				.prepareStatement("SELECT * FROM ebook_repo WHERE id=?");
		pstmt.setString(1, res_id1);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		Ebook ebook = new Ebook();
		ebook.setAuthor(rs.getString(4));
		ebook.setTitle(rs.getString(5));
		ebook.setClick_times(9);
		ebook.setEisbn(rs.getString(3));
		ebook.setIsbn(rs.getString(2));
		ebook.setLanguage(rs.getString(17));
		ebook.setImg_url(rs.getString(14));
		ebook.setUrl(rs.getString(13));
		ebook.setPages(rs.getString(6));
		ebook.setPublisher(rs.getString(8));
		ebook.setYear(rs.getString(9));
		pstmt.close();
		sqlconn.close();
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		Document document = new Document();
		Gson gson = new Gson();
		String json = gson.toJson(ebook);
		document= Document.parse(json);
		collection.insertOne(document);
	}
	
	
}
