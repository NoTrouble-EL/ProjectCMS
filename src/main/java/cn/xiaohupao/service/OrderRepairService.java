package cn.xiaohupao.service;

import cn.xiaohupao.domain.OrderRepair;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/20 16:50
 */
public interface OrderRepairService {

    List<OrderRepair> queryAll(OrderRepair orderRepair);
    OrderRepair queryById(int orderId);
    void addOrderRepair(OrderRepair orderRepair);
    void updateOrderRepair(OrderRepair orderRepair);
}
