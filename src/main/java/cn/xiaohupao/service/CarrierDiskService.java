package cn.xiaohupao.service;

import cn.xiaohupao.domain.CarrierDisk;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/11/3 13:31
 */
public interface CarrierDiskService {
    void addCarrierDisk(CarrierDisk carrierDisk);
    List<CarrierDisk> queryAll();
}
