package com.cc.controller.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import com.cc.bean.News;
import com.cc.utility.MongoConn;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

public class NewsController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String mongodbTableName="res_news_info";
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		List<Document> foundDocument = collection.find().into(new ArrayList<Document>());
		
		String json=null;	
		Gson gson = new Gson();
		json = gson.toJson(foundDocument);
		
        resp.setContentType("application/json;charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.write(json.getBytes("utf-8"));
        
        System.out.println(json);
	}
}
