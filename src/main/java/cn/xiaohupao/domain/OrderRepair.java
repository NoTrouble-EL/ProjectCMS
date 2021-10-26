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
public class OrderRepair {

  private Integer orderId;
  private String orderType;
  private Integer progressId;
  private String restoreResult;
  private long userId;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date startTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date endTime;

  private String status;
  private String spstatus;
  private String reason;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date takeoutTime;
  private long cusId;

  private String progressName;
  private String realName;
  private String cusName;

  private String begin;
  private String end;
  private String[] dateRange;

  private Integer pageSize;
  private Integer currentPage;
  private Integer startRow;
}
