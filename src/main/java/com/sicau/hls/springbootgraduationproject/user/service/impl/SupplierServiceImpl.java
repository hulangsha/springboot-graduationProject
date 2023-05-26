package com.sicau.hls.springbootgraduationproject.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.common.result.PageResult;
import com.sicau.hls.springbootgraduationproject.dto.QuerySupplier;
import com.sicau.hls.springbootgraduationproject.dto.SupplierInfo;
import com.sicau.hls.springbootgraduationproject.user.entity.Supplier;
import com.sicau.hls.springbootgraduationproject.user.mapper.SupplierMapper;
import com.sicau.hls.springbootgraduationproject.user.service.SupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
    @Override
    public Page<Supplier> getSupplierPage(QuerySupplier querySupplier) {
        Page<Supplier> page = new Page<>();
        page.setCurrent(querySupplier.getCurrentPage());
        page.setSize(querySupplier.getPageSize());
        QueryWrapper<Supplier> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }

    @Override
    public Page<Supplier> getSupplierSearch(QuerySupplier querySupplier) {
        Page<Supplier> page = new Page<>();
        page.setCurrent(querySupplier.getCurrentPage());
        page.setSize(querySupplier.getPageSize());
        QueryWrapper<Supplier> wrapper = new QueryWrapper<>();
        if(querySupplier.getSupplierName() != "" && querySupplier.getMobile() == ""){
            wrapper.eq("supplier_name",querySupplier.getSupplierName());
        }
        if (querySupplier.getSupplierName() == "" && querySupplier.getMobile() != ""){
            wrapper.eq("mobile",querySupplier.getMobile());
        }
        if(querySupplier.getMobile() != "" && querySupplier.getSupplierName() != ""){
            wrapper.eq("mobile",querySupplier.getMobile()).eq("supplier_name",querySupplier.getSupplierName());
        }
        return page(page,wrapper);
    }

    @Override
    public boolean getSupplierAdd(SupplierInfo supplierInfo) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierInfo,supplier);
        return this.save(supplier);
    }

    @Override
    public boolean getSupplierUpdate(SupplierInfo supplierInfo) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierInfo,supplier);
        return this.updateById(supplier);
    }

    @Override
    public boolean getSupplierDelete(Integer supplierId) {
        return this.removeById(supplierId);
    }
}
