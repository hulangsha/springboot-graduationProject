package com.sicau.hls.springbootgraduationproject.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.common.result.PageResult;
import com.sicau.hls.springbootgraduationproject.dto.QuerySupplier;
import com.sicau.hls.springbootgraduationproject.dto.SupplierInfo;
import com.sicau.hls.springbootgraduationproject.user.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
public interface SupplierService extends IService<Supplier> {
    Page<Supplier> getSupplierPage(QuerySupplier querySupplier);
    Page<Supplier> getSupplierSearch(QuerySupplier querySupplier);
    boolean getSupplierAdd(SupplierInfo supplierInfo);
    boolean getSupplierUpdate(SupplierInfo supplierInfo);
    boolean getSupplierDelete(Integer supplierId);
}
