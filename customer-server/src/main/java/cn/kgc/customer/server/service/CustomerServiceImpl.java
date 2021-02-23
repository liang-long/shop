package cn.kgc.customer.server.service;

import cn.kgc.customer.server.mapper.CustomerMapper;
import cn.kgc.shop.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tiler on 2020/5/11
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Integer addOneCustomer(Customer customer) {
        return customerMapper.insertOneCustomer(customer);
    }

    @Override
    public Customer getByUsername(String username) {
        Customer customer = customerMapper.selectByUsername(username);

        //空对象
        if (customer == null) {
            customer = new Customer();
            customer.setId(0);
        }

        return customer;
    }

    @Override
    public Integer setOneCustomer(Customer customer) {
        return customerMapper.updateOneCustomer(customer);
    }
}
