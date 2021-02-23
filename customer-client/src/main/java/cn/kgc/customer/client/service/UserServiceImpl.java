package cn.kgc.customer.client.service;

import cn.kgc.customer.client.dao.UserDao;
import cn.kgc.shop.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tiler on 2020/6/5
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Value("${user.expire.seconds}")
    private Integer timeout;

    //用户信息可以序列化成Json字符串后存储
    @Override
    public void addOneUser(String token, Customer user) {
        Map<String, String> map = new HashMap<>();
        map.put("id", user.getId().toString());
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        map.put("name", user.getName());
        map.put("phone", user.getPhone());
        map.put("address", user.getAddress());
        map.put("cartNum", user.getCartNum().toString());

        userDao.hashMultiSet(token, map);
        userDao.setExpire(token, timeout); //刷新过期时间
    }

    @Override
    public Customer getUserByToken(String token) {
        Map<Object, Object> map = userDao.hashGetAll(token);
        if (map == null || map.isEmpty()) {
            return new Customer();
        }

        Customer user = new Customer();
        user.setId(Integer.parseInt((String)map.get("id")));
        user.setName((String)map.get("name"));
        user.setUsername((String)map.get("username"));
        user.setPassword((String)map.get("password"));
        user.setPhone((String)map.get("phone"));
        user.setAddress((String)map.get("address"));
        user.setCartNum(Integer.parseInt((String)map.get("cartNum")));

        userDao.setExpire(token, timeout); //刷新过期时间

        return user;
    }

    @Override
    public void setUserExpire(String token) {
        userDao.setExpire(token, timeout);
    }
}
