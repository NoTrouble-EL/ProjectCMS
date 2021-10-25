package cn.xiaohupao.service.impl;

import cn.xiaohupao.dao.OrderCustomerDao;
import cn.xiaohupao.domain.OrderCustomer;
import cn.xiaohupao.service.OrderCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/25 18:26
 */
@Service
public class OrderCustomerServiceImpl implements OrderCustomerService {

    @Autowired
    private OrderCustomerDao orderCustomerDao;

    @Override
    public List<OrderCustomer> queryAll() {
        return orderCustomerDao.queryAll();
    }
}
