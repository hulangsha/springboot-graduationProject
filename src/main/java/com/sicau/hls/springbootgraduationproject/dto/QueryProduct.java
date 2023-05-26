package com.sicau.hls.springbootgraduationproject.dto;

import lombok.Data;

@Data
public class QueryProduct {
    private Integer productId;
    private String productName;
    private Float price;
    private Integer stock;
    private String type;
    private Integer supplierId;
    private Integer currentPage;
    private Integer pageSize;

}
