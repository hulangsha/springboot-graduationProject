package com.sicau.hls.springbootgraduationproject.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.dto.BillInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryBillInfo;
import com.sicau.hls.springbootgraduationproject.user.entity.Bill;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-30
 */
public interface BillService extends IService<Bill> {
    Page<Bill> getBillPage(QueryBillInfo queryBillInfo);
    Page<Bill> getSearchBill(QueryBillInfo queryBillInfo);
    boolean getBillAdd(BillInfo billInfo);
    boolean getBillUpdate(BillInfo billInfo);
    boolean getBillDelete(Integer billId);
}
