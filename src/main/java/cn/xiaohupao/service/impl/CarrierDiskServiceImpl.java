package cn.xiaohupao.service.impl;

import cn.xiaohupao.dao.CarrierDiskDao;
import cn.xiaohupao.domain.CarrierDisk;
import cn.xiaohupao.service.CarrierDiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/11/3 13:32
 */
@Service
public class CarrierDiskServiceImpl implements CarrierDiskService {

    private final CarrierDiskDao carrierDiskDao;

    @Autowired
    public CarrierDiskServiceImpl(CarrierDiskDao carrierDiskDao) {
        this.carrierDiskDao = carrierDiskDao;
    }

    @Override
    public void addCarrierDisk(CarrierDisk carrierDisk) {
        carrierDiskDao.addCarrierDisk(carrierDisk);
    }

    @Override
    public List<CarrierDisk> queryAll() {
        return carrierDiskDao.queryAll();
    }
}
