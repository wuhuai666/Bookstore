package com.atwuhuai.service.impl;

import com.atwuhuai.dao.UserDao;
import com.atwuhuai.dao.impl.UserDaoimpl;
import com.atwuhuai.pojo.User;
import com.atwuhuai.service.UserService;

public class UserServiceimpl implements UserService {
private UserDao userDao=new UserDaoimpl();

    @Override
    public void registUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User login(User user) {

        try {
            return   userDao.queryUserNameandPassword(user.getUsername(),user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserName(username)==null){
            return false;
        }
        return  true;
    }
}
