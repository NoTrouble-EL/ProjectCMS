package cn.xiaohupao.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrierImage {

  private Integer imageId;
  private String imageUrl;
  private Integer orderId;
  private String type;
  private String imageName;

}
