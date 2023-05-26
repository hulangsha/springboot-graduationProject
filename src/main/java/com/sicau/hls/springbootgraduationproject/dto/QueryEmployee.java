package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

/**
 * 分页查询
 */
@Data
public class QueryEmployee {
    private Integer currentPage;
    private Integer pageSize;
    private Integer employeeId;
    private String employeeName;
    private String contactNumber;
    private String position;
    private String sex;
    private String age;
    private String password;
}
