package cn.xiaohupao.dao;

import cn.xiaohupao.domain.CarrierDisk;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/11/3 13:26
 */
public interface CarrierDiskDao {

    void addCarrierDisk(CarrierDisk carrierDisk);

    List<CarrierDisk> queryAll();
}
