package com.sicau.hls.springbootgraduationproject.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.common.result.PageResult;
import com.sicau.hls.springbootgraduationproject.common.result.Result;
import com.sicau.hls.springbootgraduationproject.dto.BillInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryBillInfo;
import com.sicau.hls.springbootgraduationproject.user.entity.Bill;
import com.sicau.hls.springbootgraduationproject.user.service.BillService;
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
 * @since 2023-04-30
 */
@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @GetMapping("/page")
    @RequiresRoles(value = {"admin","staff"},logical = Logical.OR)
    public PageResult<?> getBillPage(QueryBillInfo queryBillInfo){
        Page<Bill> page = billService.getBillPage(queryBillInfo);
        PageResult<Bill> result = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    @GetMapping("/search")
    public PageResult<?> getSearchBill(QueryBillInfo queryBillInfo){
        Page<Bill> page = billService.getSearchBill(queryBillInfo);
        PageResult<Bill> result = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    @PostMapping("/add")
    public Result<?> getBillAdd(@RequestBody BillInfo billInfo){
        boolean result = billService.getBillAdd(billInfo);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @PostMapping("/update")
    public Result<?> getBillUpdate(@RequestBody BillInfo billInfo){
        boolean result = billService.getBillUpdate(billInfo);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @PostMapping("/delete")
    public Result<?> getBillDelete(Integer billId){
        boolean result = billService.getBillDelete(billId);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }
}
