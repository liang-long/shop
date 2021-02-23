package cn.kgc.product.server.mapper;

import cn.kgc.shop.common.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Tiler on 2020/5/6
 */
@Mapper
public interface CategoryMapper {
    public List<Category> selectAllCategories();
    public Category selectCategoryById(Integer id);
}
