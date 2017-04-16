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
import com.cc.utility.ReadFileToString;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

/**
 * Test echarts
 */
public class TestECharts extends HttpServlet {
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
		
		String json = ReadFileToString.readFile("F:\\project\\testECharts\\webkit-dep.json");
		
		// 发布 json 串到 API
        resp.setContentType("application/json;charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.write(json.getBytes("utf-8"));
        
        // 控制台打印发布的信息
        System.out.println(json);
	}
}
