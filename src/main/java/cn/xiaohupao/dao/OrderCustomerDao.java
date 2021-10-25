package cn.xiaohupao.dao;

import cn.xiaohupao.domain.OrderCustomer;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/25 18:20
 */
public interface OrderCustomerDao {

    /**
     * 查询所有的消费者信息
     * @return 所有的消费者信息List
     */
    List<OrderCustomer> queryAll();
}
