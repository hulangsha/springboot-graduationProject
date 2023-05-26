package com.sicau.hls.springbootgraduationproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class QueryBillInfo {
    private Integer currentPage;
    private Integer pageSize;

    private Integer billId;
    private String productName;
    private Float price;
    private Float totalPrice;
    private Integer quantity;
    private Integer employeeId;
    private String supplierName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

}
