package cn.kgc.customer.client.controller;

import cn.kgc.customer.client.service.UserService;
import cn.kgc.shop.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tiler on 2020/5/11
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/{token}")
    public Integer addOneUser(@PathVariable("token") String token,
                              @RequestBody Customer user) {
        userService.addOneUser(token, user);
        return 1;
    }

    @GetMapping("/users/{token}")
    public Customer getUserByToken(@PathVariable("token") String token) {
        return userService.getUserByToken(token);
    }

    @PutMapping("/users/{token}")
    public Integer setUserExpire(@PathVariable("token") String token) {
        userService.setUserExpire(token);

        return 1;
    }
}
