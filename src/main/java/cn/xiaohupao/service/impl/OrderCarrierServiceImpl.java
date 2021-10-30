package cn.xiaohupao.service.impl;

import cn.xiaohupao.dao.OrderCarrierDao;
import cn.xiaohupao.domain.OrderCarrier;
import cn.xiaohupao.service.OrderCarrierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/30 11:29
 */
@Service
public class OrderCarrierServiceImpl implements OrderCarrierService {

    private final OrderCarrierDao orderCarrierDao;

    @Autowired
    public OrderCarrierServiceImpl(OrderCarrierDao orderCarrierDao) {
        this.orderCarrierDao = orderCarrierDao;
    }

    @Override
    public List<OrderCarrier> queryAll() {
        return orderCarrierDao.queryAll();
    }

    @Override
    public PageInfo<OrderCarrier> queryAllByPojo(OrderCarrier orderCarrier, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderCarrier> orderCarriers = orderCarrierDao.queryAllByPojo(orderCarrier);
        return new PageInfo<>(orderCarriers);
    }

    @Override
    public OrderCarrier queryById(Integer id) {
        return orderCarrierDao.queryById(id);
    }

    @Override
    public void update(OrderCarrier orderCarrier) {
        orderCarrierDao.updateOrderCarrier(orderCarrier);
    }

    @Override
    public void addOrderCarrier(OrderCarrier orderCarrier) {
        orderCarrierDao.addOrderCarrier(orderCarrier);
    }
}
