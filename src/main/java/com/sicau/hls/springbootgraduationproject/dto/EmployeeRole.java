package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

/**
 * 公司员工角色管理
 */
@Data
public class EmployeeRole {
    private Integer employeeId;
    private String employeeName;
    private Integer roleId;
    private String roleCode;
    private String roleName;
}
