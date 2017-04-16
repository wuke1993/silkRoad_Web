package com.cc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.cc.utility.MongoConn;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

/**
 * Servlet implementation class RecommendationController
 * 获取 user_id, 读取Mongodb中预先计算好的推荐结果(存储在Collection recResult中),并输出到API中
 */
public class RecController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) 
			throws ServletException, IOException {
		// request中获取user_id，目前未实现，默认为admin
		String user_id = (String) request.getAttribute("user_id");
		
		// 通过 user_id 访问从 Collection recResult 获取推荐结果
		String mongodbCollectionName="recResult";
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbCollectionName);
		
		user_id = "admin"; // 目前均默认用户是 admin
		Bson filter = Filters.eq("user_id", user_id);
		List<Document> foundDocument = collection.find(filter).into(new ArrayList<Document>());
		
		// Document list 借助 Gson 转化为 String 
		String json=null;
		Gson gson = new Gson();
		json = gson.toJson(foundDocument);
		
		// 发布 json 串到 API
        resp.setContentType("application/json;charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.write(json.getBytes("utf-8"));
        
        // 获取客户端IP地址
        System.out.println("客户端的IP地址为：" + request.getRemoteAddr());
        
        // 控制台打印发布的信息
        System.out.println(json);
	}
}
