package cn.xiaohupao.service.impl;

import cn.xiaohupao.dao.OrderRepairDao;
import cn.xiaohupao.domain.OrderRepair;
import cn.xiaohupao.service.OrderRepairService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/20 16:51
 */
@Service
public class OrderRepairServiceImpl implements OrderRepairService {

    private final OrderRepairDao orderRepairDao;

    @Autowired
    public OrderRepairServiceImpl(OrderRepairDao orderRepairDao) {
        this.orderRepairDao = orderRepairDao;
    }

    @Override
    public PageInfo<OrderRepair> queryAll(OrderRepair orderRepair, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderRepair> orderRepairs = orderRepairDao.queryAll(orderRepair);
        return new PageInfo<>(orderRepairs);
    }

    @Override
    public List<OrderRepair> queryAllRepairId() {
        return orderRepairDao.queryAllOrderId();
    }

    @Override
    public OrderRepair queryById(int orderId) {
        return orderRepairDao.queryById(orderId);
    }

    @Override
    public void addOrderRepair(OrderRepair orderRepair) {
        orderRepairDao.addOrderRepair(orderRepair);
    }

    @Override
    public void updateOrderRepair(OrderRepair orderRepair) {
        orderRepairDao.updateOrderRepair(orderRepair);
    }

    @Override
    public void deleteOrderRepairById(int orderId) {
        orderRepairDao.deleteOrderRepairById(orderId);
    }
}
