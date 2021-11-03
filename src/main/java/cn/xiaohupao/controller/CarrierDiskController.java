package cn.xiaohupao.controller;

import cn.xiaohupao.domain.CarrierDisk;
import cn.xiaohupao.service.CarrierDiskService;
import cn.xiaohupao.utils.ObjectExcelView;
import cn.xiaohupao.utils.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/11/3 13:34
 */
@RestController
@RequestMapping("/carrierDisk")
public class CarrierDiskController {

    private final CarrierDiskService carrierDiskService;

    @Autowired
    public CarrierDiskController(CarrierDiskService carrierDiskService) {
        this.carrierDiskService = carrierDiskService;
    }

    @GetMapping("queryAll")
    public List<CarrierDisk> queryAll(){
        return carrierDiskService.queryAll();
    }

    @PostMapping("add")
    public void addCarrierDisk(@RequestBody CarrierDisk carrierDisk){
        carrierDiskService.addCarrierDisk(carrierDisk);
    }

    @GetMapping("downExcel")
    public ModelAndView downExcel(){
        ModelAndView mav = null;
        try {
            Map<String, Object> dataMap = new HashMap<>(2);

            List<String> titles = new ArrayList<>();
            titles.add("编号");
            titles.add("品牌类型");
            titles.add("容量");
            titles.add("类型");
            titles.add("序列号");
            titles.add("工单编号");
            titles.add("是否为新硬盘");
            dataMap.put("titles", titles);

            List<CarrierDisk> carrierDisks = carrierDiskService.queryAll();
            List<PageData> varList = new ArrayList<>();
            for (int i = 0; i < carrierDisks.size(); i++){
                PageData pd = new PageData();
                pd.put("var1", carrierDisks.get(i).getDiskId());
                pd.put("var2", carrierDisks.get(i).getBrandId());
                pd.put("var3", carrierDisks.get(i).getCapacity());
                pd.put("var4", carrierDisks.get(i).getModel());
                pd.put("var5", carrierDisks.get(i).getSerialnumber());
                pd.put("var6", carrierDisks.get(i).getOrderId());
                pd.put("var7", carrierDisks.get(i).getIsnew());
                varList.add(pd);
            }
            dataMap.put("varList", varList);
            ObjectExcelView erv = new ObjectExcelView();
            mav = new ModelAndView(erv, dataMap);
        }catch (Exception e){
            e.printStackTrace();
        }

        return mav;
    }
}
