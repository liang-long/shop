package cn.kgc.product.client.service;

import cn.kgc.shop.common.entity.ProductPage;

import java.util.Map;

/**
 * Created by Tiler on 2020/5/6
 */
public interface ProductService {
    public ProductPage getAllProducts(Map<String, Object> map);
}
