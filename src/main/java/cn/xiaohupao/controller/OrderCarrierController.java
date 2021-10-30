package cn.xiaohupao.controller;

import cn.xiaohupao.domain.OrderCarrier;
import cn.xiaohupao.service.OrderCarrierService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/30 11:30
 */
@RestController
@RequestMapping("/ordercarrier")
public class OrderCarrierController {

    private final OrderCarrierService orderCarrierService;

    @Autowired
    public OrderCarrierController(OrderCarrierService orderCarrierService) {
        this.orderCarrierService = orderCarrierService;
    }

    @GetMapping("queryAll")
    public List<OrderCarrier> queryAll(){
        return orderCarrierService.queryAll();
    }

    @PostMapping("queryAllByPojo/{pageSize}/{pageNum}")
    public PageInfo<OrderCarrier> queryAllByPojo(@RequestBody OrderCarrier orderCarrier, @PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum){
        return orderCarrierService.queryAllByPojo(orderCarrier, pageSize,pageNum);
    }

    @GetMapping("queryById/{id}")
    public OrderCarrier queryById(@PathVariable("id") Integer id){
        return orderCarrierService.queryById(id);
    }

    @PostMapping("update")
    public void update(@RequestBody OrderCarrier orderCarrier){
        orderCarrierService.update(orderCarrier);
    }

    @PostMapping("add")
    public void addOrderCarrier(@RequestBody OrderCarrier orderCarrier){
        orderCarrierService.addOrderCarrier(orderCarrier);
    }
}
