package com.atwuhuai.dao;

import com.atwuhuai.pojo.User;

public interface UserDao {

    /**
     * 根据用户名进行查询
     * @param username 用户名
     * @return 若返回null,则没有该用户
     */
    public User queryUserName(String username);

    /**
     * 根据用户名和用户密码查询
     * @param username
     * @param password
     * @return  若返回为null,则登陆失败
     */
    public  User queryUserNameandPassword(String username,String password);

    /**
     * 插入用户信息
      * @param user
     * @return  若插入失败,则返回-1,已存在用户
     */
    public int insertUser(User user);
}
