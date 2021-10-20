package priv.lsx.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author lsx
 * @since 2021-03-06
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel("Persons")
public class Persons implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     * <p>
     * //
     */
    @ApiModelProperty("id")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;


    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;
    //字符串转date
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:dd:ss")
    //"date": "2018-08-01T14:25:31.296+0000"
    //2018-08-01 14:32:57
    //jackson在序列化时间时是按照国际标准时间GMT进行格式化的，而在国内默认时区使用的是CST时区，两者相差8小时
    @JsonFormat(pattern = "yyyy-MM-dd HH:dd:ss", timezone = "GMT+8")
    @ApiModelProperty("时间")
    private Date time;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;

}
