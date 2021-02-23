package cn.kgc.customer.server.controller;

import cn.kgc.customer.server.service.CustomerService;
import cn.kgc.shop.common.entity.Customer;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tiler on 2020/6/1
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation("增加一个客户")
    @ApiImplicitParam(name = "customer", value = "客户信息", required = true, dataType = "Customer", paramType = "body")
    @PostMapping("/customers")
    public Integer addOneCustomer(@RequestBody Customer customer) {
        return customerService.addOneCustomer(customer);
    }

    @ApiOperation("根据用户名查询")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query")
    @GetMapping("/customers")
    public Customer getByUsername(String username) {
        return customerService.getByUsername(username);
    }

    @ApiOperation("修改用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "customerId", value = "客户id号", required = true, dataType = "int", paramType = "path"),
        @ApiImplicitParam(name = "customer", value = "客户信息", required = true, dataType = "Customer", paramType = "body")
    })
    @PutMapping("/customers/{customerId}")
    public Integer setOneCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer) {
        return customerService.setOneCustomer(customer);
    }
}
