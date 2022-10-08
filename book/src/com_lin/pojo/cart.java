package com_lin.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class cart {
    //购物车对象
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer, cartItem> items = new LinkedHashMap<>();


    //方法
    public void addItem(cartItem cartItem) {
        //先查看购物车是否有此商品
        cartItem item = items.get(cartItem.getId());
        if (item == null) {
            //之前没添加过此商品
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);//数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void updateCount(Integer id, Integer count) {
        cartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }


    @Override
    public String toString() {
        return "cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {//从items中遍历出所有的数量然后累加
        Integer totalCount = 0;
        for (Map.Entry<Integer, cartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {//从items中遍历出所有的金额然后累加
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, cartItem> entry : items.entrySet()) {
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, cartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, cartItem> items) {
        this.items = items;
    }
}
