package cn.xiaohupao.dao;

import cn.xiaohupao.domain.OrderCarrier;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/30 10:53
 */
public interface OrderCarrierDao {

    void addOrderCarrier(OrderCarrier orderCarrier);
    void deleteOrderCarrierById(Integer id);
    void updateOrderCarrier(OrderCarrier orderCarrier);
    List<OrderCarrier> queryAll();
    OrderCarrier queryById(Integer id);
    List<OrderCarrier> queryAllByPojo(OrderCarrier orderCarrier);
}
