package cn.kgc.order.client.controller;

import cn.kgc.order.client.service.AuthorizeService;
import cn.kgc.order.client.service.CartItemService;
import cn.kgc.order.client.service.ProductService;
import cn.kgc.shop.common.entity.CartItem;
import cn.kgc.shop.common.entity.Customer;
import cn.kgc.shop.common.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Tiler on 2020/5/15
 */
@Controller
@RequestMapping("/cart")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthorizeService authorizeService;

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        Customer user = (Customer) session.getAttribute("user");
        System.out.println("user:" + user);

        Float total = 0f;
        StringBuilder builder = new StringBuilder();

        //拼接所有商品的ID号
        List<CartItem> items = cartItemService.getByPidCid(null, user.getId());
        for (CartItem item : items) {
            if (builder.length() > 0) {
                builder.append(",");
            }

            builder.append(item.getProduct().getId());
        }

        //查询购物车内所有商品
        List<Product> products = productService.getProductByList(builder.toString());

        //商品放入购物车中
        for (CartItem item : items) {
            Integer pid = item.getProduct().getId();

            for (Product product : products) {
                if (product.getId().equals(pid)) {
                    item.setProduct(product);
                    break;
                }
            }

            total += item.getNumber() * item.getProduct().getPrice();
        }

        model.addAttribute("items", items);
        model.addAttribute("total", total);

        return "cart_details";
    }

/*
    @RequestMapping("add_item")
    @ResponseBody
    public Map<String, Object> addOneItem(CartItem cartItem, HttpSession session) {
        Map<String, Object> result = new HashMap<>();

        Customer user = (Customer) session.getAttribute("user");
        if (user == null) {
            result.put("success", false);
            result.put("message", "请登录后再购物");

            return result;
        }

        //判断是否有此商品
        Integer pid = cartItem.getProduct().getId();
        CartItem item = cartItemService.getByPidCid(pid, user.getId());

        //设置用户信息
        cartItem.setCustomer(user);

        //商品数量
        Integer status = 0, count = 0;

        if (item == null) { //新增
            cartItem.setNumber(1);
            status = cartItemService.addOneItem(cartItem);

            if (status > 0) {
                //购物车商品数量加一
                Integer num = user.getCartNum() + 1;

                user.setCartNum(num);
                result.put("success", true);  //增加
                result.put("message", num);   //返回购物车商品数量
            }
            else {
                result.put("success", false);
                result.put("message", "数据库增加失败");
            }
        }
        else {              //更新数量
            cartItem.setId(item.getId());
            cartItem.setNumber(item.getNumber() + 1);
            status = cartItemService.setOneItem(cartItem);

            if (status > 0) {
                result.put("success", true); //修改
            }
            else {
                result.put("success", false);
                result.put("message", "数据库更新失败");
            }
        }

        return result;
    }

    @RequestMapping("set_number")
    @ResponseBody
    public Map<String, Object> setItemNum(CartItem cartItem) {
        Map<String, Object> result = new HashMap<>();

        if (cartItemService.setOneItem(cartItem) > 0) {
            result.put("success", true);
        }
        else {
            result.put("success", false);
            result.put("message", "数据库更新失败");
        }

        return result;
    }

    @RequestMapping("del_item")
    @ResponseBody
    public Map<String, Object> delItemById(Integer id, HttpSession session) {
        Map<String, Object> result = new HashMap<>();

        Customer user = (Customer)session.getAttribute("user");

        if (cartItemService.delItemById(id) > 0) {
            user.setCartNum(user.getCartNum() - 1);
            result.put("success", true);
        }
        else {
            result.put("success", false);
            result.put("message", "数据库删除失败");
        }

        return result;
    }
    */
}
