package com.atwuhuai.dao.impl;

import com.atwuhuai.dao.UserDao;
import com.atwuhuai.pojo.User;

public class UserDaoimpl  extends BaseDao implements UserDao {
    @Override
    /**
     * 查询用户姓名
     */
    public User queryUserName(String username) {
        String sql="select id,level,username,password,email from t_users where username=?";
        return queryForOne(User.class,sql,username);
    }

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    @Override
    public User queryUserNameandPassword(String username, String password) {
        String sql="select id,level,username,password,email from t_users where username=? and password=?";
        return  queryForOne(User.class,sql,username,password);
    }

    @Override
    public int insertUser(User user) {
        String sql="insert into t_users(username,password,email,level)value(?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getLevel());
    }
}
