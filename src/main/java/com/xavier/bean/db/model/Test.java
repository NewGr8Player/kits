package com.xavier.bean.db.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

    public static final String url = "jdbc:mysql://localhost:3306/restful?characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";

    public static void test() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","root");
            String sql = "select * from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            sb.append("package cn.test.entity;\r\n");
            sb.append("public class Test {\r\n");
            // 获取列名及类型
            int colunmCount = rs.getMetaData().getColumnCount();
            String[] colNameArr = new String[colunmCount];
            String[] colTypeArr = new String[colunmCount];
            for (int i = 0; i < colunmCount; i++) {
                colNameArr[i] = rs.getMetaData().getColumnName(i + 1);
                colTypeArr[i] = rs.getMetaData().getColumnTypeName(i + 1);
                System.out.println(colNameArr[i] + "(" + colTypeArr[i] + ")" + " | ");
                if (colTypeArr[i].toLowerCase().equals("varchar") || colTypeArr[i].toLowerCase().equals("nvarchar")) {
                    sb.append("\tprivate String " + colNameArr[i] + ";\r\n");

                }
            }
            sb.append("}");
            System.out.println(sb);
            System.out.println(" success ... ");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (null != rs) {
                    rs.close();
                }
                if (null != ps) {
                    ps.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void main(String[] args) {
        test();
    }
}
