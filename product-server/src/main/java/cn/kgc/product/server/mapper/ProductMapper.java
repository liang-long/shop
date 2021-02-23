package cn.kgc.product.server.mapper;

import cn.kgc.shop.common.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/5/6
 */
@Mapper
public interface ProductMapper {
    //通过map传递参数，使用键名进行值的引用
    public List<Product> selectAllProducts(Map<String, Object> map);
    //通过id列表查询一组商品
    public List<Product> selectProductByList(List<Integer> productIds);
}
