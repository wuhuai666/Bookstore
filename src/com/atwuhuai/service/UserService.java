package com.atwuhuai.service;


import com.atwuhuai.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 判断是否存在用户
     * @return  返回true 则表示用户存在<br/> 返回false 表示用户不存在
     */
    public boolean existsUsername(String username);
}
