package cn.kgc.order.server.mapper;

import cn.kgc.shop.common.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Tiler on 2020/5/20
 */
@Mapper
public interface OrderMapper {
    public Integer insertOneOrder(Order order);
    public List<Order> selectOrdersByCid(@Param("customerId") Integer customerId,
                                         @Param("status") Integer status);
}
