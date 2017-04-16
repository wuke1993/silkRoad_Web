package com.cc.processing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bson.Document;

import com.cc.bean.News;
import com.cc.bean.User;
import com.cc.utility.MongoConn;
import com.cc.utility.MysqlConn;
import com.mongodb.client.MongoCollection;

public class GenerateHotNews {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		generateNews();
	}
	public static void generateNews() throws Exception {
		String mongodbTableName="res_news_info";
		String res_id1 ="001475763788237ad56318156bc4349af55d3365fe33820000";
		MysqlConn mysqlConn = new MysqlConn();
		Connection sqlconn = mysqlConn.createConnPool();
		PreparedStatement pstmt = sqlconn
				.prepareStatement("SELECT * FROM crawler_repo WHERE id=?");
		pstmt.setString(1, res_id1);
		ResultSet resultSet = pstmt.executeQuery();
		resultSet.next();
		News news = new News();
		news.setContent(resultSet.getString(3));
		news.setTitle(resultSet.getString(2));
		news.setImageUrl(resultSet.getString(8));
		news.setDate(resultSet.getDate(9));
		news.setUrl(resultSet.getString(6));
		pstmt.close();
		sqlconn.close();
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		Document document = new Document();
		document.append("res_id", res_id1).
		append("url", news.getUrl()).
		append("click_times", 400).
		append("imageUrl", news.getImageUrl()).
		append("content", news.getContent()).
		append("date", news.getDate()).
		append("title", news.getTitle());
		collection.insertOne(document);
		
		
		Document document3 = new Document("click_time", "2016-11-16 13:02:47").
				append("res_id", "00147584817501367cc3ae6c77a4b49a628571ac0cc6e27000").
				append("res_type", "news").
				append("url", "http://ikcest.xjtu.edu.cn/info/1002/29560.htm");
	
		Document document4 = new Document("click_time", "2016-10-4 13:02:47").
				append("res_id", "00147584816433907fc8f043bde4aa5ba46866a1c6f502d000").
				append("res_type", "news").
				append("url", "http://ikcest.xjtu.edu.cn/info/1002/29557.htm");
	}
}
