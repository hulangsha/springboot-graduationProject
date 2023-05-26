package com.sicau.hls.springbootgraduationproject.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "supplier_id", type = IdType.AUTO)
    private Integer supplierId;

    @TableField("supplier_name")
    private String supplierName;

    @TableField("type")
    private String type;

    @TableField("mobile")
    private String mobile;

    @TableField("address")
    private String address;

    @TableField("create_by")
    private Integer createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "operator", fill = FieldFill.UPDATE)
    private String operator;


}
