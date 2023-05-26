package com.sicau.hls.springbootgraduationproject.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * @since 2023-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bill")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bill_id", type = IdType.AUTO)
    private Integer billId;

    @TableField("product_name")
    private String productName;

    @TableField("quantity")
    private Integer quantity;

    @TableField("price")
    private Float price;

    @TableField("total_price")
    private Float totalPrice;

    @TableField("order_date")
    private LocalDate orderDate;

    @TableField("supplier_name")
    private String supplierName;

    @TableField("employee_id")
    private Integer employeeId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "operator", fill = FieldFill.UPDATE)
    private String operator;


}
