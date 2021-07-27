package com.atwuhuai.test;

import java.util.HashMap;
import java.util.Map;

public class WuHuai {
    Map<String,Integer> map=new HashMap<>();
    Integer knowledge=20;
    Integer power=100;
    Integer sleep=7;
    protected void goodDay(){
        map.put("knowledge",++knowledge);
        map.put("power",++power);
        map.put("sleep",++sleep);
        System.out.println("Better later than never.");
    }
}
