package cn.kgc.order.client.service;

import cn.kgc.shop.common.entity.CartItem;

import java.util.List;

/**
 * Created by Tiler on 2020/6/3
 */
public interface CartItemService {
    public List<CartItem> getByPidCid(Integer productId, Integer customerId);
/*
    public Integer addOneItem(CartItem cartItem);
    public Integer setOneItem(CartItem cartItem);
    public Integer getItemCount(Integer customerId);
    public List<CartItem> getByPidCid(Integer productId, Integer customerId);
    public Integer delItemById(Integer id);
    public Integer delItemsByCid(Integer customerId);*/
}
