package cn.xiaohupao.service.impl;

import cn.xiaohupao.dao.CarrierImageDao;
import cn.xiaohupao.domain.CarrierImage;
import cn.xiaohupao.service.CarrierImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/31 15:14
 */
@Service
public class CarrierImageServiceImpl implements CarrierImageService {

    private final CarrierImageDao carrierImageDao;

    @Autowired
    public CarrierImageServiceImpl(CarrierImageDao carrierImageDao) {
        this.carrierImageDao = carrierImageDao;
    }

    @Override
    public void addCarrierImage(CarrierImage carrierImage) {
        carrierImageDao.addCarrierImage(carrierImage);
    }

    @Override
    public void updateCarrierImage(CarrierImage carrierImage) {
        carrierImageDao.updateCarrierImage(carrierImage);
    }

    @Override
    public List<CarrierImage> queryAll() {
        return carrierImageDao.queryAll();
    }

    @Override
    public CarrierImage queryById(Integer id) {
        return carrierImageDao.queryById(id);
    }

    @Override
    public void deleteById(Integer id) {
        carrierImageDao.deleteById(id);
    }
}
