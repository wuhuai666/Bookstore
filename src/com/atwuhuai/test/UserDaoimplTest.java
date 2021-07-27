package com.atwuhuai.test;

import com.atwuhuai.dao.UserDao;
import com.atwuhuai.dao.impl.UserDaoimpl;
import com.atwuhuai.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoimplTest {
    @Test
    public void queryUserName() {
        UserDao userDao=new UserDaoimpl();
        System.out.println(userDao.queryUserName("吴淮"));
    }
    @Test
    public void queryUserNameandPassword() {
        UserDao userDao=new UserDaoimpl();
        System.out.println(userDao.queryUserNameandPassword("吴淮","wuhuai123"));
    }
//    @Test
//    public void insertUser() {
//        User user=new User(null,"奥莉割","123445","123@qq.com");
//        UserDao userDao=new UserDaoimpl();
//        userDao.insertUser(user);
//    }
}