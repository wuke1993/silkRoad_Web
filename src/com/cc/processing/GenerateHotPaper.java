package com.cc.processing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bson.Document;

import com.cc.bean.Paper;
import com.cc.bean.Patent;
import com.cc.utility.MongoConn;
import com.cc.utility.MysqlConn;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

public class GenerateHotPaper {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		generateHotPaper();
	}

	public static void generateHotPaper() throws Exception {
		String mongodbTableName = "res_paper_info";
		String res_id1 = "00147671579193787566288a95345a3818f6daac623220f000";
		MysqlConn mysqlConn = new MysqlConn();
		Connection sqlconn = mysqlConn.createConnPool();
		PreparedStatement pstmt = sqlconn.prepareStatement("SELECT * FROM uansr_repo WHERE id=?");
		pstmt.setString(1, res_id1);
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		Paper p = new Paper();
		p.setRes_id(res_id1);
		p.setClick_times(900);
		p.setVolume(rs.getString(6));
		p.setDoi(rs.getString(13));
		p.setTitle(rs.getString(3));
		p.setYear(rs.getString(4));
		p.setUrl(rs.getString(14));
		p.setSummary(rs.getString(17));

		pstmt.close();
		sqlconn.close();
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		Document document = new Document();
		Gson gson = new Gson();
		String json = gson.toJson(p);
		document = Document.parse(json);
		collection.insertOne(document);

	}
}
