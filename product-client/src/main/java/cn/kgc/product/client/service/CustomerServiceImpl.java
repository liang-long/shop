package cn.kgc.product.client.service;

import cn.kgc.shop.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Tiler on 2020/6/1
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.customer.url}")
    private String restUrl;

    @Override
    public Customer getByUsername(String username) {
        String url = restUrl + "?username=" + username;

        return restTemplate.getForObject(url, Customer.class);
    }

    @Override
    public Integer setOneCustomer(Customer customer) {
        restTemplate.put(restUrl + "/" + customer.getId(), customer);

        return 1;
    }
}
