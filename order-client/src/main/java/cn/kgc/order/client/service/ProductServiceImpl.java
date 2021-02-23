package cn.kgc.order.client.service;

import cn.kgc.shop.common.entity.Product;
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
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.product.url}")
    private String restUrl;

    @Override
    public List<Product> getProductByList(String productIds) {
        String url = restUrl + "/" + productIds;

        Product[] products = restTemplate.getForObject(url, Product[].class);

        return Arrays.asList(products);
    }
}
