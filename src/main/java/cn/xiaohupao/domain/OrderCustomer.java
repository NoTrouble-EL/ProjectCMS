package cn.xiaohupao.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCustomer {

  private Integer cusId;
  private String cusName;
  private String cusUnit;
  private String provinceCode;
  private String province;
  private String cityCode;
  private String city;
  private String areaCode;
  private String area;
  private String cusAddress;
  private String cusTel;
  private Integer cerId;
  private String cusNo;
  private String fax;
  private String postcode;
  private Integer attId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date createDate;
  private String oldName;

}
