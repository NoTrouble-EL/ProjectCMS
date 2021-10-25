package cn.xiaohupao.controller;

import cn.xiaohupao.domain.OrderCustomer;
import cn.xiaohupao.service.OrderCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/25 21:40
 */
@RestController
@RequestMapping("/OrderCustomer")
public class OrderCustomerController {

    private final OrderCustomerService orderCustomerService;

    @Autowired
    public OrderCustomerController(OrderCustomerService orderCustomerService) {
        this.orderCustomerService = orderCustomerService;
    }

    @GetMapping("queryAll")
    public List<OrderCustomer> queryAll(){
        return orderCustomerService.queryAll();
    }
}
