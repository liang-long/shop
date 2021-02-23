package cn.kgc.product.client.service;

import cn.kgc.shop.common.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Tiler on 2020/5/29
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.categories.url}")
    private String restUrl;

    @Override
    public List<Category> getAllCategories() {
        Category[] categories = restTemplate.getForObject(restUrl, Category[].class);

        return Arrays.asList(categories);
    }
}
