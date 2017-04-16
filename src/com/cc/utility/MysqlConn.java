package com.cc.utility;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/16.
 */
public class MysqlConn {

    public static void main(String[] args){
//        createConnPool();
    }


    public  Connection createConnPool(){
     ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/silk_road?useUnicode=true&characterEncoding=UTF-8&useSSL=true");
        ds.setUser("root");
        ds.setPassword("123456");
        ds.setMinPoolSize(2);
        ds.setMaxPoolSize(40);
        ds.setInitialPoolSize(10);
        ds.setMaxStatements(200);
        try {
            Connection conn = ds.getConnection();
            System.out.println("Connect to Mysql successfully");
            return conn;
//        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM companies_repo");
//            ResultSet rs = pstmt.executeQuery();
//            while(rs.next()){
//
//            System.out.println(rs.getString(2));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
