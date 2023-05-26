package com.sicau.hls.springbootgraduationproject.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.dto.CustomerInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryCustomer;
import com.sicau.hls.springbootgraduationproject.user.entity.Customers;
import com.sicau.hls.springbootgraduationproject.user.mapper.CustomersMapper;
import com.sicau.hls.springbootgraduationproject.user.service.CustomersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
@Service
public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements CustomersService {

    @Override
    public List<Customers> getCustomerList(QueryCustomer queryCustomer) {
        QueryWrapper<Customers> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_name",queryCustomer.getCustomerName());
        return this.list(wrapper);
    }

    @Override
    public Page<Customers> getCustomerPage(QueryCustomer queryCustomer) {
        Page<Customers> page = new Page<>();
        page.setCurrent(queryCustomer.getCurrentPage());
        page.setSize(queryCustomer.getPageSize());
        QueryWrapper<Customers> wrapper = new QueryWrapper<>();
        if (queryCustomer.getPassword()!=null){
            wrapper.eq("password",queryCustomer.getPassword());
        }
        return this.page(page,wrapper);
    }

    @Override
    public Page<Customers> getCustomerOrContactNumber(QueryCustomer queryCustomer) {
        Page<Customers> page = new Page<>();
        page.setCurrent(queryCustomer.getCurrentPage());
        page.setSize(queryCustomer.getPageSize());
        QueryWrapper<Customers> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(queryCustomer.getCustomerName())){
            wrapper.like("customer_name",queryCustomer.getCustomerName());
        }else if(!StringUtils.isEmpty(queryCustomer.getCustomerName())){
            wrapper.likeRight("contact_number",queryCustomer.getContactNumber());
        }else if(!StringUtils.isEmpty(queryCustomer.getCustomerName()) && !StringUtils.isEmpty(queryCustomer.getCustomerName())){
            wrapper.like("customer_name",queryCustomer.getCustomerName()).likeRight("contact_number",queryCustomer.getContactNumber());
        }else {
            wrapper.like("customer_name",queryCustomer.getCustomerName()).likeRight("contact_number",queryCustomer.getContactNumber());
        }

        return this.page(page,wrapper);
    }

    @Override
    public boolean addCustomer(CustomerInfo customerInfo) {
        Customers customers = new Customers();
        BeanUtils.copyProperties(customerInfo,customers);
        return this.save(customers);
    }

    @Override
    public boolean updateCustomer(CustomerInfo customerInfo) {
        Customers customers = new Customers();
        BeanUtils.copyProperties(customerInfo,customers);
        return this.updateById(customers);
    }

    @Override
    public boolean deleteCustomer(Integer customerId) {
        return this.removeById(customerId);
    }
}
