package com.zj.utils;

import com.zj.vo.RequestParam;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 13661
 */
public class OracleImportUtils {
    public static void importSqlForOracle(RequestParam param) throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@" + param.getIp() + ":" + param.getPort();
        if (StringUtils.isNotBlank(param.getServiceName())) {
            url = url + ":" + param.getServiceName();
        } else if (StringUtils.isNotBlank(param.getPid())) {
            url = url + "/" + param.getServiceName();
        }
        String driverClassName = "oracle.jdbc.driver.OracleDriver";
        String user = param.getUsername();
        String password = param.getPassword();
        String sqlPath = param.getSqlPath();

        Class.forName(driverClassName);
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);

        if (conn != null) {
            System.out.println("获取连接成功");
            // 获取连接成功，调用插入方法
            insert(conn, getSql(sqlPath));
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

    public static List<String> getSql(String sqlPath) {
        List<String> list = new ArrayList<>();
//        File readFile = new File(sqlPath);
        BufferedReader reader = null;
        InputStreamReader inputStreamReader = null;
        StringBuilder sb = new StringBuilder();
        try {
//            reader = new BufferedReader(new FileReader(readFile));
            inputStreamReader = new InputStreamReader(
                    Files.newInputStream(new File(sqlPath).toPath()), StandardCharsets.UTF_8);
            reader = new BufferedReader(inputStreamReader);

            String tempString = null;
            int line = 0;
            while ((tempString = reader.readLine()) != null) {
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
            insert(conn, getSql("C:\\Users\\13661\\Desktop\\test.sql"));
        } else {
            System.out.println("获取连接失败");
        }

    }

}