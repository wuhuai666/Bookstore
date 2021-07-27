package com.atwuhuai.dao.impl;
import com.atwuhuai.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public abstract class BaseDao {
    private QueryRunner runner=new QueryRunner();
    /**
     * update操作:insert,update,delete
     * @param sql  传入的sql语句
     * @param args   args为操作数
     * @return  -1为失败,成功为影响的行数
     */
    public int update( String sql, Object... args) {
        //获取连接
        Connection conn=JdbcUtils.getConnect();
        try {
            return  runner.update(conn,sql,args);
        } catch (Exception e) {
           //抛出异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询一条结果
     * @param type 泛型数据,
     * @param sql 输入的sql语句
     * @param args  操作数
     * @param <T>  泛型
     * @return  返回查询到的数据
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection connect = JdbcUtils.getConnect();
        try {
            return runner.query(connect,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            //抛出异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多行记录
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryList(Class<T> type,String sql,Object ...args){
        Connection conn=JdbcUtils.getConnect();
        try {
            return runner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            //抛出异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 返回单列的某一个值,
     * @param sql
     * @param args
     * @return
     */
    public Object querySingleValue(String sql,Object ...args){
        Connection connect = JdbcUtils.getConnect();
        try {
            return runner.query(connect, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            //抛出异常
            throw new RuntimeException(e);
        }
    }
}
