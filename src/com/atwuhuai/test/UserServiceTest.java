package com.atwuhuai.test;

import com.atwuhuai.pojo.User;
import com.atwuhuai.service.UserService;
import com.atwuhuai.service.impl.UserServiceimpl;
import com.atwuhuai.utils.JdbcUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
  UserService userService=new UserServiceimpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"2131231","1234","123@guigu.com","0"));
        JdbcUtils.commitAndClose();
    }

    @Test
    public void login() {
      System.out.println(userService.login(new User(null,"shabi","wuhuai123",null,"0")));
      JdbcUtils.commitAndClose();
    }

    @Test
    public void existsUsername() {
      System.out.println(userService.existsUsername("wuhuai1234"));
    }
}