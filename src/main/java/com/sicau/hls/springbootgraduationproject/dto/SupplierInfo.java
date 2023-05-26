package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

@Data
public class SupplierInfo {
    private Integer supplierId;
    private String supplierName;
    private String type;
    private String mobile;
    private String address;
    private Integer createBy;
}
