package cn.kgc.product.client.service;

import cn.kgc.shop.common.entity.Customer;

/**
 * Created by Tiler on 2020/6/5
 */
public interface AuthorizeService {
    public Integer addOneUser(String token, Customer user);
    public Customer getUserByToken(String token);
}
