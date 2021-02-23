package cn.kgc.order.server.service;

import cn.kgc.order.server.mapper.CartItemMapper;
import cn.kgc.shop.common.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiler on 2020/5/15
 */
@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemMapper cartItemMapper;

    @Override
    public Integer addOneItem(CartItem cartItem) {
        return cartItemMapper.insertOneItem(cartItem);
    }

    @Override
    public Integer setOneItem(CartItem cartItem) {
        return cartItemMapper.updateOneItem(cartItem);
    }

    @Override
    public Integer getItemCount(Integer customerId) {
        return cartItemMapper.selectItemCount(customerId);
    }

    @Override
    public List<CartItem> getByPidCid(Integer productId, Integer customerId) {
        List<CartItem> list = new ArrayList<>();

        CartItem item = cartItemMapper.selectByPidCid(productId, customerId);
        if (item != null) { list.add(item); }

        return list;
    }

    @Override
    public List<CartItem> getItemsByCid(Integer customerId) {
        List<CartItem> list = cartItemMapper.selectItemsByCid(customerId);

        if (list == null) {
            return new ArrayList<>();
        }
        else {
            return list;
        }
    }

    @Override
    public Integer delItemById(Integer id) {
        return cartItemMapper.deleteItemById(id);
    }

    @Override
    public Integer delItemsByCid(Integer customerId) {
        return cartItemMapper.deleteItemsByCid(customerId);
    }
}
