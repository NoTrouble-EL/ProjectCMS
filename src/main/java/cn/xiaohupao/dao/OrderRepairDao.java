package cn.xiaohupao.dao;

import cn.xiaohupao.domain.OrderRepair;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/20 16:27
 */

public interface OrderRepairDao {

    /**
     * 通过传入的参数查询用户
     * @param orderRepair orderRepair对象
     * @return 所有符合条件的用户
     */
    List<OrderRepair> queryAll(OrderRepair orderRepair);

    /**
     * 根据Id查询用户
     * @param orderId id
     * @return 用户信息
     */
    OrderRepair queryById(int orderId);

    /**
     * 增 传入的用户对象
     * @param orderRepair orderRepair对象
     */
    void addOrderRepair(OrderRepair orderRepair);

    /**
     * 改 根据传入的用户对象的id来更新数据
     * @param orderRepair orderRepair对象
     */
    void updateOrderRepair(OrderRepair orderRepair);
}
