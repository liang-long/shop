package cn.kgc.product.client.service;

import cn.kgc.shop.common.entity.Customer;

/**
 * Created by Tiler on 2020/6/1
 */
public interface CustomerService {
    public Customer getByUsername(String username);
    public Integer setOneCustomer(Customer customer);
}
