package com.cc.processing;

import com.cc.utility.MongoConn;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/11/17.
 */
public class InsertRse_info {
    public static void main(String[] args) throws Exception{
        insert_res_info();
    }
    public static void insert_res_info()throws Exception{
        String mongodbTableName="res_info";
        MongoConn mongoConn = new MongoConn();
        MongoCollection<Document> collection = mongoConn.conn(mongodbTableName);
        Process process = new Process();
        List<Map<String,String>> list =process.processByMap();
        for (Map<String,String> map :list){
            Document document = new Document();
            document.putAll(map);
            collection.insertOne(document);
        }

    }

}
