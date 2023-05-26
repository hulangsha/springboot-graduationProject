package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

/**
 * 公司员工权限管理
 */
@Data
public class EmployeePerms {
    private Integer employeeId;
    private String employeeName;
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private Integer permsId;
    private String permsCode;
    private String permsName;
}
