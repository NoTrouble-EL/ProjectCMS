package cn.xiaohupao.service;

import cn.xiaohupao.domain.CarrierImage;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/31 15:13
 */
public interface CarrierImageService {
    void addCarrierImage(CarrierImage carrierImage);
    void updateCarrierImage(CarrierImage carrierImage);
    List<CarrierImage> queryAll();
    CarrierImage queryById(Integer id);
    void deleteById(Integer id);
}
