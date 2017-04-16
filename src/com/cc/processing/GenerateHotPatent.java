package com.cc.processing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bson.Document;

import com.cc.bean.News;
import com.cc.bean.Paper;
import com.cc.bean.Patent;
import com.cc.utility.MongoConn;
import com.cc.utility.MysqlConn;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

public class GenerateHotPatent {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		generateHotPatent();
	}
	public static void  generateHotPatent() throws Exception {
		String mongodbTableName="res_patent_info";
		String res_id1 ="0014761738444460c59f8e20f484657b364adbb60ddb1e3000";
		MysqlConn mysqlConn = new MysqlConn();
		Connection sqlconn = mysqlConn.createConnPool();
		PreparedStatement pstmt = sqlconn
				.prepareStatement("SELECT * FROM patent_repo WHERE id=?");
		pstmt.setString(1, res_id1);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		Patent patent = new Patent();
		patent.setAssignee_name(rs.getString(5));
		patent.setClick_times(250);
		patent.setInventor(rs.getString(4));
		patent.setTitle(rs.getString(3));
		patent.setUrl("http://ikcest.xjtu.edu.cn/patent_n_content.jsp?urltype=tree.TreeTempUrl&"
				+ "wbtreeid=1214&patent_number=CN105288654-A");
		patent.setPatent_number(rs.getString(2));
		patent.setRes_id(res_id1);
		pstmt.close();
		sqlconn.close();
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		Document document = new Document();
		Gson gson = new Gson();
		String json = gson.toJson(patent);
		document= Document.parse(json);
		collection.insertOne(document);
		
	}
}
