package com.atwuhuai.test;

import com.atwuhuai.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class Test1 {
    @Test
    public void test(){
        Connection connect = JdbcUtils.getConnect();
        for (int i=0;i<9;i++){
            System.out.println(connect);
        }
//        JdbcUtils.closeConnect(connect);
    }
}
