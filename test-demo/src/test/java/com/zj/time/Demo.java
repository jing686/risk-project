package com.zj.time;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
 
        final String url = "jdbc:oracle:thin:@192.168.119.10:1521:orcl";
        final String driverClassName = "oracle.jdbc.driver.OracleDriver";
        final String user = "wateruser";
        final String password = "itcast";
 
        Class.forName(driverClassName);
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);
 
        if (conn != null ) {
            System.out.println( "获取连接成功" );
            // 获取连接成功，调用插入方法
            insert(conn);
        } else {
            System.out.println( "获取连接失败" );
        }
 
    }
 
    /**
     * 实际执行插入数据的方法
     * @param conn
     */
    public static void insert(Connection conn) {
 
        try {
            // 设置事务的提交方式为手动提交
            conn.setAutoCommit(false);
            //获取当前的时间，看下总共用了多久时间添加完千万数据
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            System.out.println(dateFormat.format(date));
 
 
            String sql = "INSERT INTO USSER3 ("
                    + "ID,"
                    +"NAME2,"
                    + "PASSWORD,"
                    + "INSERTTIME"
                    +")"
                    +"VALUES(?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
 
            // 向数据库表table_name中批量插入1千万条数据
            for (int i = 1; i <= 100000; i++) {
                pstm.setInt(1, i);  // 为第一个字段赋值（即：替换第一个问号的值）
                pstm.setString(2, "i");  // 为第二个字段赋值（即：替换第二个问号的值）
                pstm.setString(3, "男");  // 为第三个字段赋值（即：替换第三个问号的值）
                pstm.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                pstm.addBatch();   // 添加
 
                // 设置每5000条sql语句提交一次事务（说明，5000这个值不是固定的，根据实际情况来设置，值不同，插入的效率也不同，需经过测试才能获取最合适的值）
                if (i % 5000 == 0) {
                    pstm.executeBatch();   // 执行
                    pstm.clearBatch();     // 清空
                    conn.commit();         // 手动提交事务
                }
            }
            pstm.executeBatch();   // 执行
            pstm.clearBatch();     // 清空
            conn.commit();         // 手动提交事务
 
            // 调用释放资源的方法
            close(pstm, conn);
 
        } catch (SQLException e) {
            System.out.println("bbbbb");
            e.printStackTrace();
        }
    }
 
    /**
     * 释放资源的方法
     * @param pstm
     * @param conn
     */
    public static void close(PreparedStatement pstm, Connection conn) {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
           //获取添加完数据，结束后的时间
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            System.out.println(dateFormat.format(date));
            System.out.println("连接关闭，程序结束！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接关闭失败");
        }
    }
 
}