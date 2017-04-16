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
 * ��ȡ user_id, ��ȡMongodb��Ԥ�ȼ���õ��Ƽ����(�洢��Collection recResult��),�������API��
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
		// request�л�ȡuser_id��Ŀǰδʵ�֣�Ĭ��Ϊadmin
		String user_id = (String) request.getAttribute("user_id");
		
		// ͨ�� user_id ���ʴ� Collection recResult ��ȡ�Ƽ����
		String mongodbCollectionName="recResult";
		MongoConn mongoConn = new MongoConn();
		MongoCollection<Document> collection = mongoConn.conn(mongodbCollectionName);
		
		user_id = "admin"; // Ŀǰ��Ĭ���û��� admin
		Bson filter = Filters.eq("user_id", user_id);
		List<Document> foundDocument = collection.find(filter).into(new ArrayList<Document>());
		
		// Document list ���� Gson ת��Ϊ String 
		String json=null;
		Gson gson = new Gson();
		json = gson.toJson(foundDocument);
		
		// ���� json ���� API
        resp.setContentType("application/json;charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.write(json.getBytes("utf-8"));
        
        // ��ȡ�ͻ���IP��ַ
        System.out.println("�ͻ��˵�IP��ַΪ��" + request.getRemoteAddr());
        
        // ����̨��ӡ��������Ϣ
        System.out.println(json);
	}
}
