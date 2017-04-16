package com.cc.controller;

import com.cc.bean.HotRes;
import com.cc.utility.MongoConn;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/18.
 */

public class ResController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MongoConn mongoConn = new MongoConn();
        MongoCollection<Document> collection = mongoConn.conn("res_info");
        List<Document> foundDocument = collection.find().into(new ArrayList<Document>());
        List<HotRes> listHotRes= new ArrayList<>();
        for (Document d:foundDocument){;
        	HotRes hotRes = new HotRes();
        	hotRes.setValue(Integer.parseInt(d.getString("times")));
        	hotRes.setName(d.getString("title"));
        	hotRes.setUrl(d.getString("url"));
        	listHotRes.add(hotRes);
        }
        Gson gson = new Gson();
        String json=gson.toJson(listHotRes);
        
        resp.setContentType("application/json;charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.print(json);
        //servletOutputStream.write(json.getBytes("utf-8"));
        
        System.out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
