package com.atwuhuai.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class servletTest {
    public void post(){
        System.out.println("这是post方法");
    }
    public void regist(){
        System.out.println("这是regist方法");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method declaredMethod = servletTest.class.getDeclaredMethod("post");
       declaredMethod.invoke(new servletTest());
    }
}

