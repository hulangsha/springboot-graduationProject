package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

/**
 * 分页查询
 */
@Data
public class QueryCustomer {
    private Integer currentPage;
    private Integer pageSize;
    private Integer customerId;
    private String customerName;
    private String contactNumber;
    private String password;

}
