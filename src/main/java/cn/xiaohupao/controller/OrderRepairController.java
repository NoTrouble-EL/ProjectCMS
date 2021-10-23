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

    @Autowired
    private OrderRepairService orderRepairService;

    @PostMapping("queryAll")
    public List<OrderRepair> queryAll(@RequestBody OrderRepair orderRepair){
        return orderRepairService.queryAll(orderRepair);
    }

    @GetMapping("queryById/{orderId}")
    public OrderRepair queryById(@PathVariable("orderId") int id){
        OrderRepair orderRepair = orderRepairService.queryById(id);
        System.out.println(orderRepair);
        return orderRepair;
    }
}
