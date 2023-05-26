package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

/**
 * 正常查询
 */
@Data
public class EmployeeInfo {
    private Integer employeeId;
    private String employeeName;
    private String contactNumber;
    private String position;
    private String sex;
    private Integer age;
    private String password;
}
