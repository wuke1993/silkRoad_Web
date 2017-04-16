package com.cc.processing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bson.Document;

import com.cc.bean.Conference;
import com.cc.bean.Paper;
import com.cc.utility.MongoConn;
import com.cc.utility.MysqlConn;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

public class GenerateHotConf {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			generate();
	}
	public static void generate() throws Exception{
		String mongodbTableName = "res_conf_info";
		String res_id1 = "001466567434684b1d10af16b844c30844c2bbf48e2dcf6000";
		MysqlConn mysqlConn = new MysqlConn();
		Connection sqlconn = mysqlConn.createConnPool();
		PreparedStatement pstmt = sqlconn.prepareStatement("SELECT * FROM conf_repo WHERE id=?");
		pstmt.setString(1, res_id1);
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		Conference conference = new Conference();
		conference.setClick_times(40);
		conference.setOnganizer(rs.getString(3));
		conference.setRes_id(res_id1);
		conference.setTitle(rs.getString(2));
		conference.setUrl(rs.getString(18));
		conference.setStart_time(rs.getString(6));
		conference.setBroad_theme(rs.getString(13));
		
		pstmt.close();
		sqlconn.close();
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		Document document = new Document();
		Gson gson = new Gson();
		String json = gson.toJson(conference);
		document = Document.parse(json);
		collection.insertOne(document);
	}
}
