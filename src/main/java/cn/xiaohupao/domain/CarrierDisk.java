package cn.xiaohupao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrierDisk {

  private Integer diskId;
  private Integer brandId;
  private String capacity;
  private String model;
  private String serialnumber;
  private Integer orderId;
  private String isnew;

}
