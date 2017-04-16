package com.cc.processing;

import com.cc.bean.ResInfo;
import com.cc.utility.MongoConn;
import com.cc.utility.MysqlConn;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/17.
 */
public class Process {
	public static void main(String[] args) throws Exception {
		process();
	}

	/*
	 * Use Object to save the result
	 */
	public static List<ResInfo> process() throws Exception {
		
		List<ResInfo> list = new ArrayList<ResInfo>();
		MysqlConn mysqlConn = new MysqlConn();
		Connection sqlconn = mysqlConn.createConnPool();
		PreparedStatement pstmt = sqlconn
				.prepareStatement("SELECT table_name FROM click_info WHERE res_id=?");

		String mongodbTableName = "logs";
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		// List<Document> foundDocument = collection.find().into(new
		// ArrayList<Document>());

		MongoCursor<String> res_idList = collection.distinct("res_id",
				String.class).iterator();
		while (res_idList.hasNext()) {
			ResInfo resInfo = new ResInfo();
			String url;
			String res_id = res_idList.next();
			Bson filter = Filters.eq("res_id", res_id);
			int times = (int) collection.count(filter);
			Document findDocument = collection.find(filter).first();
			url = findDocument.getString("url");
		
			if (!res_id.equals("")) {
				try {
					pstmt.setString(1, res_id);
					ResultSet rs = pstmt.executeQuery();
					String table_name = null;
					if (rs.next()) {
						table_name = rs.getString(1);
						rs.close();
						// System.out.println("res_id:" + res_id +
						// "     table_name:" + table_name + "      times:" +
						// times);
						PreparedStatement pstmt2 = sqlconn
								.prepareStatement("SELECT * FROM " + table_name
										+ " WHERE id=?");
						pstmt2.setString(1, res_id);
						ResultSet rs2 = pstmt2.executeQuery();
						// add class Resinfo bean;
						rs2.next();
						switch (table_name) {
						case "companies_repo":
							resInfo.setTitle(rs2.getString(2));
							break;
						case "conf_repo":
							resInfo.setTitle(rs2.getString(2));
							break;
						case "countries_repo":
							resInfo.setTitle(rs2.getString(2));
							break;
						case "crawler_repo":
							resInfo.setTitle(rs2.getString(2));
							break;
						case "dissertation_repo":
							resInfo.setTitle(rs2.getString(2));
							break;
						case "ebook_repo":
							resInfo.setTitle(rs2.getString(5));
							break;
						case "journal_repo":
							resInfo.setTitle(rs2.getString(2));
							break;
						case "oa_repo":
							resInfo.setTitle(rs2.getString(4));
							break;
						case "patent_repo":
							resInfo.setTitle(rs2.getString(3));
							break;
						case "regulation_repo":
							resInfo.setTitle(rs2.getString(3));
							break;
						case "uansr_repo":
							resInfo.setTitle(rs2.getString(3));
							break;
						case "uebook_repo":
							resInfo.setTitle(rs2.getString(5));
							break;
						default:
							resInfo.setTitle(rs2.getString(3));
						}
						resInfo.setRes_id(res_id);
						resInfo.setRes_type(table_name);
						resInfo.setTimes(times);
						resInfo.setUrl(url);
						resInfo.setUser_id("admin");
						list.add(resInfo);
						System.out.println(resInfo.toString());
						pstmt2.close();

					} else {
						System.err
								.println("Where is the fucking table_name about res_id: "
										+ res_id);
					}
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
			// System.out.println(collection.count(filter));
		}
		return list;

	}

	/*
	 * Use HashMap to save the result;
	 */
	public static List<Map<String, String>> processByMap() throws Exception {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		MysqlConn mysqlConn = new MysqlConn();
		Connection sqlconn = mysqlConn.createConnPool();
		PreparedStatement pstmt = sqlconn
				.prepareStatement("SELECT table_name FROM click_info WHERE res_id=?");
		String mongodbTableName = "logs";
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		MongoCursor<String> res_idList = collection.distinct("res_id",
				String.class).iterator();
		while (res_idList.hasNext()) {
			Map<String, String> map = new HashMap<String, String>();
			String url;
			String res_id = res_idList.next();
			Bson filter = Filters.eq("res_id", res_id);
			// long --> String + ""
			String times = collection.count(filter) + "";
			Document findDocument = collection.find(filter).first();
			url = findDocument.getString("url");
			if (!res_id.equals("")) {
				try {
					pstmt.setString(1, res_id);
					ResultSet rs = pstmt.executeQuery();
					String table_name = null;
					if (rs.next()) {
						table_name = rs.getString(1);
						rs.close();
						PreparedStatement pstmt2 = sqlconn
								.prepareStatement("SELECT * FROM " + table_name
										+ " WHERE id=?");
						pstmt2.setString(1, res_id);
						ResultSet rs2 = pstmt2.executeQuery();
						// add class Resinfo bean;
						rs2.next();
						switch (table_name) {
						case "companies_repo":
							map.put("title", rs2.getString(2));
							break;
						case "conf_repo":
							map.put("title", rs2.getString(2));
							break;
						case "countries_repo":
							map.put("title", rs2.getString(2));
							break;
						case "crawler_repo":
							map.put("title", rs2.getString(2));
							break;
						case "dissertation_repo":
							map.put("title", rs2.getString(2));
							break;
						case "ebook_repo":
							map.put("title", rs2.getString(5));
							break;
						case "journal_repo":
							map.put("title", rs2.getString(2));
							break;
						case "oa_repo":
							map.put("title", rs2.getString(4));
							break;
						case "patent_repo":
							map.put("title", rs2.getString(3));
							break;
						case "regulation_repo":
							map.put("title", rs2.getString(3));
							break;
						case "uansr_repo":
							map.put("title", rs2.getString(3));
							break;
						case "uebook_repo":
							map.put("title", rs2.getString(5));
							break;
						default:
							map.put("title", rs2.getString(2));
						}
						ObjectId _id =ObjectId.get();
						map.put("_id", _id.toHexString());
						map.put("res_id", res_id);
						map.put("res_type", table_name);
						map.put("times", times);
						map.put("url", url);
						list.add(map);
						pstmt2.close();
					} else {
						System.out
								.println("Where is the fucking table_name about res_id: "
										+ res_id);
					}
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
			// System.out.println(collection.count(filter));
		}
		return list;

	}
}
