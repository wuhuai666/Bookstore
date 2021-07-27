package com.atwuhuai.utils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
/*
 此类用于管理数据库连接池,德鲁伊
 */
public class JdbcUtils {
    private  static DruidDataSource dataSource;
    //创建ThreadLocal保存连接的实例化对象
    private static ThreadLocal<Connection> conns=new ThreadLocal<Connection>();
static {
    try {
        //获取文件数据流
        InputStream stream =JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        //从流中加载数据
        properties.load(stream);
        //创建数据库连接池
       dataSource= (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    //获取连接
    public  static Connection getConnect(){
       Connection connection=conns.get();
       if (connection==null){
           try {
               //第一次为空,从数据库连接池中取得
               connection=dataSource.getConnection();
               //放入连接对象到ThreadLocal中
               conns.set(connection);
               connection.setAutoCommit(false);//设置为手动提交
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
       }
         return connection;
    }
    //提交事务并关闭连接
    public static void  commitAndClose(){
        //从ThreadLocal中获取同一个conn连接对象
          Connection connection = conns.get();
        if (connection!=null){
            //不等于null,则说明之前使用过数据库
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();//去除掉,否则就会出错,因为(Tomcat底层使用了线程池技术)
    }
    //回滚事务并关闭连接
    public static void  rollbackAndClose(){
        //从ThreadLocal中获取同一个conn连接对象
        Connection connection = conns.get();
        if (connection!=null){
            //不等于null,则说明之前使用过数据库
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();//去除掉,否则就会出错,因为(Tomcat底层使用了线程池技术)
    }
}
