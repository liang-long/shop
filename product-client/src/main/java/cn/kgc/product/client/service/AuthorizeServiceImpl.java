package cn.kgc.product.client.service;

import cn.kgc.shop.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * Created by Tiler on 2020/6/5
 */
@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.authorize.url}")
    private String restUrl;

    @Override
    public Integer addOneUser(String token, Customer user) {
        String url = restUrl + "/" + token;

        return restTemplate.postForObject(url, user, Integer.class);
    }

    @Override
    public Customer getUserByToken(String token) {
        String url = restUrl + "/" + token;

        return restTemplate.getForObject(url, Customer.class);
    }
}
