package cn.kgc.product.server.service;

import cn.kgc.product.server.mapper.ProductMapper;
import cn.kgc.shop.common.entity.Product;
import cn.kgc.shop.common.entity.ProductPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/5/6
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductPage getAllProducts(Map<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");

        //设置页码和页面大小
        PageHelper.startPage(pageNum, pageSize);

        //执行查询
        List<Product> list = productMapper.selectAllProducts(map);
        PageInfo<Product> info = new PageInfo<>(list);

        //将PageInfo对象转换为ProductPage
        ProductPage page = new ProductPage();

        page.setProductsList(info.getList());
        page.setRowCount(((Long)info.getTotal()).intValue());
        page.setPageCount(info.getPages());
        page.setPageNum(pageNum);

        return page;
    }

    @Override
    public List<Product> getProductByList(String productIds) {
        List<Integer> list = new ArrayList<>();

        String[] array = productIds.split(",");

        for (String s : array) {
            list.add(Integer.parseInt(s));
        }

        return productMapper.selectProductByList(list);
    }
}
