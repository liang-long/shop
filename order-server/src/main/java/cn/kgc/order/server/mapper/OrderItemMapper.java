package cn.kgc.order.server.mapper;

import cn.kgc.shop.common.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Tiler on 2020/5/20
 */
@Mapper
public interface OrderItemMapper {
    public Integer insertAllItems(List<OrderItem> items);
    public List<OrderItem> selectItemsByOid(Integer orderId);
}
