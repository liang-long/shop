package cn.kgc.order.server.controller;

import cn.kgc.order.server.service.CartItemService;
import cn.kgc.shop.common.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tiler on 2020/6/3
 */
@RestController
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/cartItems")
    public Integer addOneItem(@RequestBody CartItem cartItem) {
        return cartItemService.addOneItem(cartItem);
    }

    @PutMapping("/cartItems/{cartItemId}")
    public Integer setOneItem(@PathVariable("cartItemId") Integer itemId,
                              @RequestBody CartItem cartItem) {
        return cartItemService.setOneItem(cartItem);
    }

    @GetMapping("/cartItems/count")
    public Integer getItemCount(Integer customerId) {
        return cartItemService.getItemCount(customerId);
    }

    @GetMapping("/cartItems")
    public List<CartItem> getByPidCid(Integer productId, Integer customerId) {
        if (productId == null) {
            return cartItemService.getItemsByCid(customerId);
        }
        else {
            return cartItemService.getByPidCid(productId, customerId);
        }
    }

    @DeleteMapping("/cartItems/{cartItemId}")
    public Integer delItemById(@PathVariable("cartItemId") Integer cartItemId) {
        return cartItemService.delItemById(cartItemId);
    }

    @DeleteMapping("/cartItems")
    public Integer delItemsByCid(Integer customerId) {
        return cartItemService.delItemsByCid(customerId);
    }
}
