package com.atwuhuai.utils;

import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class web  {
    //返回泛型的T,优点是无需强制转换.
    public  static <T> T  paramToBean(Map value, T Bean){
        try {
            //使用BeanUtils注入属性值到User对象中
            BeanUtils.populate(Bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
  return  Bean;

    }
    public  static int strToInt(String strInt,int defaultValue){
        if (strInt==null){
            return  defaultValue;
        }else{
            try {
                    return Integer.parseInt(strInt);
            } catch (NumberFormatException e) {
            e.printStackTrace();
        }
            return -1;
        }

    }
}
