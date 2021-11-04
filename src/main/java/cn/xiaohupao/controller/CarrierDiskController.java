package cn.xiaohupao.controller;

import cn.xiaohupao.domain.CarrierDisk;
import cn.xiaohupao.service.CarrierDiskService;
import cn.xiaohupao.utils.ObjectExcelRead;
import cn.xiaohupao.utils.ObjectExcelView;
import cn.xiaohupao.utils.PageData;
import cn.xiaohupao.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @RequestMapping(value = "/importExcel")
    public Result readExcel(@RequestParam(value = "excel", required = false) MultipartFile file, HttpServletRequest request){
        PageData pd = new PageData();
        if (null != file && !file.isEmpty()){
            try {
                List<PageData> objects = ObjectExcelRead.readExcel(file.getInputStream(), 1, 0, 0);
                for (int i = 0; i < objects.size(); i++){
                    CarrierDisk carrierDisk = new CarrierDisk();
                    String strDiskId = objects.get(i).getString("var0");
                    int diskId = 0;
                    if (strDiskId.indexOf(".")!= -1){
                        diskId = Integer.parseInt(strDiskId.substring(0, strDiskId.indexOf(".")));
                    }else{
                        diskId = Integer.parseInt(strDiskId);
                    }
                    carrierDisk.setDiskId(diskId);

                    String strBrandId = objects.get(i).getString("var1");
                    int brandId = 0;
                    if (strBrandId.indexOf(".")!= -1){
                        brandId = Integer.parseInt(strBrandId.substring(0, strBrandId.indexOf(".")));
                    }else{
                        brandId = Integer.parseInt(strBrandId);
                    }
                    carrierDisk.setBrandId(brandId);
                    carrierDisk.setCapacity(objects.get(i).getString("var2"));
                    carrierDisk.setModel(objects.get(i).getString("var3"));
                    carrierDisk.setSerialnumber(objects.get(i).getString("var4"));

                    String strOrderId = objects.get(i).getString("var5");
                    int orderId = 0;
                    if (strOrderId.indexOf(".")!= -1){
                        orderId = Integer.parseInt(strOrderId.substring(0, strOrderId.indexOf(".")));
                    }else{
                        orderId = Integer.parseInt(strOrderId);
                    }
                    carrierDisk.setOrderId(orderId);
                    carrierDisk.setIsnew(objects.get(i).getString("var6"));
                    carrierDiskService.addCarrierDisk(carrierDisk);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Result(true, "/upload/");
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        carrierDiskService.deleteById(id);
    }

    @GetMapping("queryById/{id}")
    public CarrierDisk queryById(@PathVariable("id") Integer id){
        return carrierDiskService.queryById(id);
    }

    @PostMapping("update")
    public void update(@RequestBody CarrierDisk carrierDisk){
        carrierDiskService.update(carrierDisk);
    }
}
