package cn.xiaohupao.service;

import cn.xiaohupao.domain.OrderRepair;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/20 16:50
 */
public interface OrderRepairService {

    PageInfo<OrderRepair> queryAll(OrderRepair orderRepair, Integer pageSize, Integer pageNum);
    List<OrderRepair> queryAllRepairId();
    OrderRepair queryById(int orderId);
    void addOrderRepair(OrderRepair orderRepair);
    void updateOrderRepair(OrderRepair orderRepair);
    void deleteOrderRepairById(int orderId);
    List<OrderRepair> queryCustomer();
}
