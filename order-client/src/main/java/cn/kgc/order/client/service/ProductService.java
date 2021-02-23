package cn.kgc.order.client.service;

import cn.kgc.shop.common.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Tiler on 2020/6/3
 */
public interface ProductService {
    public List<Product> getProductByList(String productIds);
}
