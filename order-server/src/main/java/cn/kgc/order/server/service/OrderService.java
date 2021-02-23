package cn.kgc.order.server.service;

import cn.kgc.shop.common.entity.CartItem;
import cn.kgc.shop.common.entity.Customer;
import cn.kgc.shop.common.entity.Order;

import java.util.List;

/**
 * Created by Tiler on 2020/5/20
 */
public interface OrderService {
    //public Integer addOneOrder(List<CartItem> items, Customer user);
    public List<Order> getOrdersByCid(Integer customerId, Integer status);
}
