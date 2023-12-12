package cn.fog.tj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fog
 * @since 2023-12-04
 */
@TableName("x_month")
@Data
public class Month implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String month;

    private Integer num;

    /**
     * 人员更替数量表
     */
    private String personnel;
    /**
     * 用户评价表
     */
    private String appraise;

}
