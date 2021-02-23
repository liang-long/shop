package cn.kgc.product.client.service;

import cn.kgc.shop.common.entity.Product;
import cn.kgc.shop.common.entity.ProductPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Tiler on 2020/5/29
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.products.url}")
    private String restUrl;

    @Override
    public ProductPage getAllProducts(Map<String, Object> map) {
        StringBuilder builder = new StringBuilder();

        //拼接参数
        for (String s : map.keySet()) {
            if (map.get(s) == null) {
                continue;
            }

            if (builder.length() > 0) {
                builder.append("&");
            }

            builder.append(s + "=");
            builder.append(map.get(s));
        }

        //System.out.println(builder.toString());
        String url = restUrl + "?" + builder.toString();

        return restTemplate.getForObject(url, ProductPage.class);
    }
}
