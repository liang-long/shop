package cn.kgc.product.server.controller;

import cn.kgc.product.server.service.ProductService;
import cn.kgc.shop.common.entity.Product;
import cn.kgc.shop.common.entity.ProductPage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tiler on 2020/5/29
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    private String getStrParam(String param) {
        if (param == null || param.trim().equals("")) {
            return null;
        }
        else {
            return param.trim();
        }
    }

    @ApiOperation("条件查询所有商品")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "productName", value = "商品名称", required = false, dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "categoryId", value = "商品分类", required = false, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "priceMax", value = "最高价格", required = false, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "priceMin", value = "最低价格", required = false, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query")
    })
    //@RequestMapping(value = "/products", method = RequestMethod.GET)
    @GetMapping("/products")
    public ProductPage getAllProducts(@ApiIgnore @RequestParam Map<String, String> map) {
        //获取参数并去掉字符串前后空格
        String productName = getStrParam(map.get("productName"));
        String strCategory = getStrParam(map.get("categoryId"));
        String strPriceMax = getStrParam(map.get("priceMax"));
        String strPriceMin = getStrParam(map.get("priceMin"));
        String strPageSize = getStrParam(map.get("pageSize"));
        String strPageNum = getStrParam(map.get("pageNum"));

        //类型转换
        Integer categoryId = strCategory == null? 1 : Integer.parseInt(strCategory);
        Integer priceMax = strPriceMax == null? null : Integer.parseInt(strPriceMax);
        Integer priceMin = strPriceMin == null? null : Integer.parseInt(strPriceMin);
        Integer pageSize = strPageSize == null? 10 : Integer.parseInt(strPageSize);
        Integer pageNum = strPageNum == null? 1 : Integer.parseInt(strPageNum);

        //查询参数
        Map<String, Object> query = new HashMap<>();
        query.put("categoryId", categoryId);
        query.put("productName", productName);
        query.put("priceMax", priceMax);
        query.put("priceMin", priceMin);
        query.put("pageSize", pageSize);
        query.put("pageNum", pageNum);

        //查询
        return productService.getAllProducts(query);
    }

    @ApiOperation("根据ID查询一组商品")
    @ApiImplicitParam(name = "pids", value = "一到多个商品ID", required = true, dataType = "string", paramType = "path")
    @GetMapping("/products/{pids}")
    public List<Product> getProductByList(@PathVariable("pids") String productIds) {
        List<Product> list = null;

        if (productIds != null) {
            list = productService.getProductByList(productIds);
        }

        if (list == null) {
            return new ArrayList<>();
        }
        else {
            return list;
        }
    }
}
