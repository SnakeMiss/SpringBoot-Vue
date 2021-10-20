package priv.lsx.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
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
public class SelectQuery implements Serializable {

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

    @TableField(fill = FieldFill.INSERT)
    private String createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;


}

