package com.cc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ApiController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> map = new HashMap<>();
		//String ip = "202.117.15.155";
		//String ip = "219.245.39.39";
		//String ip = "123.206.87.123";
		String ip = "101.201.116.244";
		//String ip = "202.117.15.156";
		String port = "8080";
		
		//map.put("Resource", "http://" + ip + ":" + port + "/silkRoad2/res_info");
		map.put("UserProfile", "http://" + ip + ":" + port + "/silkRoad2/user_info");
		map.put("News", "http://" + ip + ":" + port + "/silkRoad2/news_info");
		map.put("Patent", "http://" + ip + ":" + port + "/silkRoad2/patent_info");
		map.put("Ebook", "http://" + ip + ":" + port + "/silkRoad2/ebook_info");
		map.put("Paper", "http://" + ip + ":" + port + "/silkRoad2/paper_info");
		map.put("Conference", "http://" + ip + ":" + port + "/silkRoad2/conf_info");
		map.put("RecResult", "http://" + ip + ":" + port + "/silkRoad2/rec_info");
		
		String json=null;
		Gson gson = new Gson();
		json = gson.toJson(map);
		
		resp.setContentType("application/json;charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.write(json.getBytes("utf-8"));
        
        // 获取客户端IP地址
        System.out.println("客户端的IP地址为：" + req.getRemoteAddr());

        System.out.println(json);
	}

}
