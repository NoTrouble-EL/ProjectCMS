package cn.xiaohupao.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType {

  private Integer typeId;
  private String typeName;

}
