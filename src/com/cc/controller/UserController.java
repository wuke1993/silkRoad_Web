package com.cc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.cc.utility.MongoConn;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

public class UserController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5893160252694569577L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mongodbTableName="user_info";
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
		
		Bson filter = Filters.eq("user_id", "admin");
		List<Document> foundDocument = collection.find(filter).into(new ArrayList<Document>());
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
