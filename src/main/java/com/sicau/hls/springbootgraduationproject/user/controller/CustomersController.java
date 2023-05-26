package com.sicau.hls.springbootgraduationproject.user.controller;



import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.common.component.JwtComponent;
import com.sicau.hls.springbootgraduationproject.common.result.PageResult;
import com.sicau.hls.springbootgraduationproject.common.result.Result;
import com.sicau.hls.springbootgraduationproject.dto.CustomerInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryCustomer;
import com.sicau.hls.springbootgraduationproject.user.entity.Customers;
import com.sicau.hls.springbootgraduationproject.user.service.CustomersService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/api/customer")
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @GetMapping("/page")
    @RequiresRoles(value = "admin")
    public PageResult<?> getCustomerPage(QueryCustomer queryCustomer){
        Page<Customers> customersPage = customersService.getCustomerPage(queryCustomer);
        PageResult<Customers> result = new PageResult<>(customersPage.getCurrent(), customersPage.getSize(), customersPage.getTotal(), customersPage.getPages(), customersPage.getRecords());
        result.setCode(200);
        result.setMsg("success");
        return result;
    }

    /**
     * 根据用户名或者电话查询用户
     * @param queryCustomer
     * @return
     */
    @GetMapping("/searchCustomer")
    public PageResult<?> getCustomerOrContactNumber(QueryCustomer queryCustomer){
        Page<Customers> customersPage = customersService.getCustomerOrContactNumber(queryCustomer);
        PageResult<Customers> result = new PageResult<>(customersPage.getCurrent(),customersPage.getSize(),customersPage.getTotal(),customersPage.getPages(),customersPage.getRecords());
        result.setCode(200);
        result.setMsg("success");
        return result;
    }
    @PostMapping("/add")
    public Result<?> addCustomer(@RequestBody CustomerInfo customerInfo){
        boolean result = customersService.addCustomer(customerInfo);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @GetMapping("/update")
    public Result<?> updateCustomer(CustomerInfo customerInfo){
        boolean result = customersService.updateCustomer(customerInfo);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @GetMapping("/delete")
    public Result<?> deleteCustomer(Integer customerId){
        boolean result = customersService.deleteCustomer(customerId);
        if(result){
           return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }
}
