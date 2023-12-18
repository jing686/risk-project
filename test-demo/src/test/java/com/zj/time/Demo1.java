package com.zj.time;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        final String url = "jdbc:oracle:thin:@192.168.119.10:1521:orcl";
        final String driverClassName = "oracle.jdbc.driver.OracleDriver";
        final String user = "wateruser";
        final String password = "itcast";

        Class.forName(driverClassName);
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);

        if (conn != null) {
            System.out.println("获取连接成功");
            // 获取连接成功，调用插入方法
            insert(conn, getSql());
        } else {
            System.out.println("获取连接失败");
        }

    }

    /**
     * 实际执行插入数据的方法
     *
     * @param conn
     */
    public static void insert(Connection conn, List<String> sqlList) {

        try {
            // 设置事务的提交方式为手动提交
            conn.setAutoCommit(false);
            //获取当前的时间，看下总共用了多久时间添加完千万数据
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            System.out.println(dateFormat.format(date));

            Statement statement = conn.createStatement();

            for (int i = 0; i < sqlList.size(); i++) {
                statement.execute(sqlList.get(i));

                if (i % 5000 == 0) {
                    conn.commit();        // 手动提交事务
                    conn.setAutoCommit(false);
                }
            }
            conn.commit();
            // 调用释放资源的方法
            close(statement, conn);

        } catch (SQLException e) {
            System.out.println("bbbbb");
            e.printStackTrace();
        }
    }


    /**
     * 释放资源的方法
     *
     * @param pstm
     * @param conn
     */
    public static void close(Statement pstm, Connection conn) {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
            //获取添加完数据，结束后的时间
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            System.out.println(dateFormat.format(date));
            System.out.println("连接关闭，程序结束！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接关闭失败");
        }
    }

    public static List<String> getSql() {
        List<String> list = new ArrayList<>();
        File readFile = new File("C:\\Users\\13661\\Desktop\\test.sql");
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(readFile));

            String tempString = null;
            int line = 0;
            while ((tempString = reader.readLine()) != null) {//BufferedReader有readLine()，可以实现按行读取
                if (StringUtils.isNotBlank(tempString)) {
                    sb.append(tempString);
                    continue;
                }
                if (sb.length() > 0) {
                    list.add(sb.substring(0, sb.length() - 1));
                    sb.delete(0, sb.length());
                }
                line++;
            }
            System.out.println("line = " + line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return list;
    }

}