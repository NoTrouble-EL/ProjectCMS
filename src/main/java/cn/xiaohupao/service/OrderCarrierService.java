package cn.xiaohupao.service;

import cn.xiaohupao.domain.OrderCarrier;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/30 11:28
 */
public interface OrderCarrierService {
    List<OrderCarrier> queryAll();
    PageInfo<OrderCarrier> queryAllByPojo(OrderCarrier orderCarrier, Integer pageSize, Integer pageNum);
    OrderCarrier queryById(Integer id);
    void update(OrderCarrier orderCarrier);
    void addOrderCarrier(OrderCarrier orderCarrier);
}
