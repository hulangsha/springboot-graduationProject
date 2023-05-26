package com.sicau.hls.springbootgraduationproject.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.dto.CustomerInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryCustomer;
import com.sicau.hls.springbootgraduationproject.user.entity.Customers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.hls.springbootgraduationproject.user.entity.Employees;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
public interface CustomersService extends IService<Customers> {
    List<Customers> getCustomerList(QueryCustomer queryCustomer);
    Page<Customers> getCustomerPage(QueryCustomer queryCustomer);
    Page<Customers> getCustomerOrContactNumber(QueryCustomer queryCustomer);
    boolean addCustomer(CustomerInfo customerInfo);
    boolean updateCustomer(CustomerInfo customerInfo);
    boolean deleteCustomer(Integer customerId);


}
