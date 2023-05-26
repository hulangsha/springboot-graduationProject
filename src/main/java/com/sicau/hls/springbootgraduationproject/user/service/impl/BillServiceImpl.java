package com.sicau.hls.springbootgraduationproject.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.dto.BillInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryBillInfo;
import com.sicau.hls.springbootgraduationproject.user.entity.Bill;
import com.sicau.hls.springbootgraduationproject.user.mapper.BillMapper;
import com.sicau.hls.springbootgraduationproject.user.service.BillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-30
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {
    @Override
    public Page<Bill> getBillPage(QueryBillInfo queryBillInfo) {
        Page<Bill> page = new Page<>();
        page.setCurrent(queryBillInfo.getCurrentPage());
        page.setSize(queryBillInfo.getPageSize());
        QueryWrapper<Bill> wrapper = new QueryWrapper<>();
        return this.page(page,wrapper);
    }

    @Override
    public Page<Bill> getSearchBill(QueryBillInfo queryBillInfo) {
        Page<Bill> page = new Page<>();
        page.setCurrent(queryBillInfo.getCurrentPage());
        page.setSize(queryBillInfo.getPageSize());
        QueryWrapper<Bill> wrapper = new QueryWrapper<>();
        if(queryBillInfo.getProductName() != "" && queryBillInfo.getEmployeeId() == null){
            wrapper.eq("product_name",queryBillInfo.getProductName());
        }

        if(queryBillInfo.getProductName() == "" && queryBillInfo.getEmployeeId() != null){
            wrapper.eq("employee_id",queryBillInfo.getEmployeeId());
        }

        if(queryBillInfo.getProductName() != "" && queryBillInfo.getEmployeeId() != null){
            wrapper.eq("employee_id",queryBillInfo.getEmployeeId()).eq("product_name",queryBillInfo.getProductName());
        }
        return this.page(page,wrapper);
    }

    @Override
    public boolean getBillAdd(BillInfo billInfo) {
        Bill bill = new Bill();
        BeanUtils.copyProperties(billInfo,bill);
        return this.save(bill);
    }

    @Override
    public boolean getBillUpdate(BillInfo billInfo) {
        Bill bill = new Bill();
        BeanUtils.copyProperties(billInfo,bill);
        return this.updateById(bill);
    }

    @Override
    public boolean getBillDelete(Integer billId) {

        return this.removeById(billId);
    }
}
