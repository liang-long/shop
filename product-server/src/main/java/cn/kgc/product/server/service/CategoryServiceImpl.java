package cn.kgc.product.server.service;

import cn.kgc.product.server.mapper.CategoryMapper;
import cn.kgc.shop.common.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tiler on 2020/5/6
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.selectAllCategories();
    }
}
