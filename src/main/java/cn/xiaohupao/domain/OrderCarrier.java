package cn.xiaohupao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCarrier {

  private Integer carrierId;
  private Integer orderId;
  private Integer mediumId;
  private Integer interId;
  private String isShelflife;
  private String phenomenon;
  private String reason;
  private String descr;

}
