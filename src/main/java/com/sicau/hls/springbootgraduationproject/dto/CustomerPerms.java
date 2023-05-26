package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

/**
 * 顾客权限管理
 */
@Data
public class CustomerPerms {
    private Integer customerId;
    private String customerName;
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private Integer permsId;
    private String permsCode;
    private String permsName;
}
