package cn.xiaohupao.controller;

import cn.xiaohupao.domain.CarrierImage;
import cn.xiaohupao.service.CarrierImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/31 15:16
 */
@RestController
@RequestMapping("/carrierImage")
public class CarrierImageController {

    private final CarrierImageService carrierImageService;

    @Autowired
    public CarrierImageController(CarrierImageService carrierImageService) {
        this.carrierImageService = carrierImageService;
    }

    @PostMapping("add")
    public void addCarrierImage(@RequestBody CarrierImage carrierImage){
        carrierImageService.addCarrierImage(carrierImage);
    }

    @PostMapping("update")
    public void updateCarrierImage(@RequestBody CarrierImage carrierImage){
        carrierImageService.updateCarrierImage(carrierImage);
    }

    @GetMapping("queryAll")
    public List<CarrierImage> queryAll(){
        return carrierImageService.queryAll();
    }

    @GetMapping("query/{id}")
    public CarrierImage queryById(@PathVariable("id") Integer id){
        return carrierImageService.queryById(id);
    }

    @GetMapping("delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        carrierImageService.deleteById(id);
    }
}
