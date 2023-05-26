package com.sicau.hls.springbootgraduationproject.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.common.result.PageResult;
import com.sicau.hls.springbootgraduationproject.common.result.Result;
import com.sicau.hls.springbootgraduationproject.dto.QuerySupplier;
import com.sicau.hls.springbootgraduationproject.dto.SupplierInfo;
import com.sicau.hls.springbootgraduationproject.user.entity.Supplier;
import com.sicau.hls.springbootgraduationproject.user.service.SupplierService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @GetMapping("/page")
    @RequiresRoles(value = {"admin","staff"},logical = Logical.OR)
    public PageResult<?> getSupplierPage(QuerySupplier querySupplier){
        Page<Supplier> page = supplierService.getSupplierPage(querySupplier);
        PageResult<Supplier> result = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    @GetMapping("/search")
    public PageResult<?> getSupplierSearch(QuerySupplier querySupplier){
        Page<Supplier> page = supplierService.getSupplierSearch(querySupplier);
        PageResult<Supplier> result = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;

    }

    @PostMapping("/add")
    public Result<?> getSupplierAdd(@RequestBody SupplierInfo supplierInfo){
        boolean result = supplierService.getSupplierAdd(supplierInfo);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }

    }
    @PostMapping("/update")
    public Result<?> getSupplierUpdate(@RequestBody SupplierInfo supplierInfo){
        boolean result = supplierService.getSupplierUpdate(supplierInfo);
        if(result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @PostMapping("/delete")
    public Result<?> getSupplierDelete(Integer supplierId){
        boolean result = supplierService.getSupplierDelete(supplierId);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }
}
