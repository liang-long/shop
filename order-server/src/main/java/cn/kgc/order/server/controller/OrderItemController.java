package cn.kgc.order.server.controller;

import cn.kgc.order.server.service.OrderService;
import cn.kgc.shop.common.entity.Order;
import cn.kgc.shop.common.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tiler on 2020/5/20
 */
@RestController
public class OrderItemController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public List<Order> index(Integer customerId, Integer status) {
        Integer num = status == null? 0 : status;

        List<Order> orders = orderService.getOrdersByCid(customerId, num);

        for (Order order : orders) {
            System.out.println(order.getOrderNumber());

            for (OrderItem orderItem : order.getOrderItems()) {
                System.out.println(orderItem.getProduct());
            }
        }

        return orders;
    }
/*
    @RequestMapping("add_order")
    public String addOneOrder(HttpSession session) {
        Customer user = (Customer) session.getAttribute("user");

        //取出购物车中所有商品
        List<CartItem> list = cartItemService.getItemsByCid(user.getId());

        //生成订单并清空购物车
        if (orderService.addOneOrder(list, user) > 0) {
            cartItemService.delItemsByCid(user.getId());
            user.setCartNum(0); //用户购物车数量清零
        }

        return "redirect:/order/";
    }
    */
}
