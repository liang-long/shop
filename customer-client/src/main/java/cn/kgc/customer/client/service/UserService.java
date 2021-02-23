package cn.kgc.customer.client.service;

import cn.kgc.shop.common.entity.Customer;

/**
 * Created by Tiler on 2020/6/5
 */
public interface UserService {
    public void addOneUser(String token, Customer user);
    public Customer getUserByToken(String token);
    public void setUserExpire(String token);
}
