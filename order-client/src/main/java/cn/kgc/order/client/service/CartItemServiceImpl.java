package cn.kgc.order.client.service;

import cn.kgc.shop.common.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Tiler on 2020/6/3
 */
@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.cart.url}")
    private String restUrl;

    @Override
    public List<CartItem> getByPidCid(Integer productId, Integer customerId) {
        String url = restUrl + "?customerId=" + customerId;

        if (productId != null) {
            url += "&productId=" + productId;
        }

        System.out.println(url);

        CartItem[] items = restTemplate.getForObject(url, CartItem[].class);

        return Arrays.asList(items);
    }
}
