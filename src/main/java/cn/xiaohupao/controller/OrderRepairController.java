package cn.xiaohupao.controller;

import cn.xiaohupao.domain.OrderRepair;
import cn.xiaohupao.service.OrderRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/20 16:55
 */

@RestController
@RequestMapping("/OrderRepair")
public class OrderRepairController {

    private final OrderRepairService orderRepairService;

    @Autowired
    public OrderRepairController(OrderRepairService orderRepairService) {
        this.orderRepairService = orderRepairService;
    }

    @PostMapping("queryAll")
    public List<OrderRepair> queryAll(@RequestBody OrderRepair orderRepair){
        //设置查询的时间范围
        String[] dateRange = orderRepair.getDateRange();
        if(dateRange != null){
            orderRepair.setBegin(dateRange[0]);
            orderRepair.setEnd(dateRange[1]);
        }
        return orderRepairService.queryAll(orderRepair);
    }

    @GetMapping("queryById/{orderId}")
    public OrderRepair queryById(@PathVariable("orderId") int id){
        OrderRepair orderRepair = orderRepairService.queryById(id);
        System.out.println(orderRepair);
        return orderRepair;
    }

    @PostMapping("add")
    public void addOrderRepair(OrderRepair orderRepair){
        orderRepairService.addOrderRepair(orderRepair);
    }
}
