package cn.kgc.customer.client.dao;

import java.util.Map;

/**
 * Created by Tiler on 2020/6/5
 */
public interface UserDao {
    public void hashMultiSet(String key, Map<String, String> map);
    public Map<Object, Object> hashGetAll(String key);
    public void setExpire(String key, Integer sec);
}
