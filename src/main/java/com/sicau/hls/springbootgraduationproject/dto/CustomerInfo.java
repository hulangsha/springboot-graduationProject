package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

/**
 * 正常查询
 */
@Data
public class CustomerInfo {
    private Integer customerId;
    private String customerName;
    private String sex;
    private Integer age;
    private String contactNumber;
    private String password;
}
