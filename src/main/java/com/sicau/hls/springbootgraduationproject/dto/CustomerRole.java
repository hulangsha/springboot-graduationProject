package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

/**
 * 顾客角色管理
 */
@Data
public class CustomerRole {
    private Integer customerId;
    private String customerName;
    private Integer roleId;
    private String roleName;
    private String roleCode;
}
