package com.atwuhuai.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
//    private Integer totalCount;//总商品数量
//    private Integer totalPrice;//总商品价格
    private Map<Integer,CartItem> item=new LinkedHashMap<Integer,CartItem>();//购物车的商品数据
    public Cart(){}
    public Cart( Map<Integer,CartItem> cartItem) {
        this.item = cartItem;
    }
    //添加商品信息
 public void addItem(CartItem cartItem){
        //先判断购物车中是否有该商品,若有,则数量加一,若无,则直接添加
     CartItem item1 = item.get(cartItem.getId());
     if (item1==null){
         //为空,则表示没有该商品,直接添加一栏
         item.put(cartItem.getId(),cartItem);
     }else{
         //不为空,则修改该栏的数量+1
         item1.setCount(item1.getCount()+1);
         //商品总价
         item1.setTotalPrice(item1.getPrice().multiply(new BigDecimal(item1.getCount())));
     }
 }
   //删除商品信息
    public void deleteById(Integer id){
        item.remove(id);
    }
    //清空购物车
    public void clearCart(){
        item.clear();
    }
    //修改商品数量
    public void  modifyCount(Integer id,Integer totalCount){
        //先判断是否有该商品
        CartItem cartItem = item.get(id);
        if (cartItem!=null){
            //存在该商品,则修改商品数量和商品金额
            cartItem.setCount(totalCount);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }
    public Integer getTotalCount() {
        Integer totalCount=0;
        //循环遍历HashMap求得总价格
        for (Map.Entry<Integer,CartItem> entry :item.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
         for (Map.Entry<Integer,CartItem> entry:item.entrySet()){
             //商品价格相加.
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
         }
        return totalPrice;
    }



    public Map<Integer,CartItem> getCartItem() {
        return item;
    }

    public void setCartItem(Map<Integer,CartItem> cartItem) {
        this.item = cartItem;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", cartItem=" + item +
                '}';
    }
}
