package cn.kgc.product.server.controller;

import cn.kgc.product.server.service.CategoryService;
import cn.kgc.shop.common.entity.Category;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tiler on 2020/5/29
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("查询所有商品分类")
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
