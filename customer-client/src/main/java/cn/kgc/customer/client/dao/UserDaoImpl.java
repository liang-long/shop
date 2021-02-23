package cn.kgc.customer.client.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tiler on 2020/6/5
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private StringRedisTemplate redisTemplate;

    //将Map中的键值对存入redis的hash类型中
    @Override
    public void hashMultiSet(String key, Map<String, String> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public Map<Object, Object> hashGetAll(String key) {
        //HashOperations<String, String, String> ops = redisTemplate.opsForHash();
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public void setExpire(String key, Integer sec) {
        redisTemplate.expire(key, sec, TimeUnit.SECONDS);
    }
}
