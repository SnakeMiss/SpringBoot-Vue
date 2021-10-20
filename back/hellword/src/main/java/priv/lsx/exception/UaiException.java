package priv.lsx.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor//使用lombok生成无参构造器
@AllArgsConstructor//使用lombok生成所有属性参数构造器
@Data
@ToString
public class UaiException extends RuntimeException {

    private Integer code;//异常状态码
    private String msg;//异常信息

}
