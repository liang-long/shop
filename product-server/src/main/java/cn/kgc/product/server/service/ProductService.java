package cn.kgc.product.server.service;

import cn.kgc.shop.common.entity.Product;
import cn.kgc.shop.common.entity.ProductPage;

import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/5/6
 */
public interface ProductService {
    public ProductPage getAllProducts(Map<String, Object> map);
    public List<Product> getProductByList(String productIds);
}
