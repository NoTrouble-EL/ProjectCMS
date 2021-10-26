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
public class User {

  private Integer userId;
  private String userName;
  private String password;
  private String realName;
  private String lastLogin;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date lastTime;
  private String status;
  private String phone;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date createDate;
  private Integer age;
  private String email;
  private Integer typeId;

  private String typeName;

  private String begin;
  private String end;
  private String[] dateRange;

}
