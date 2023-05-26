package com.sicau.hls.springbootgraduationproject.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.dto.EmployeeInfo;
import com.sicau.hls.springbootgraduationproject.dto.EmployeePerms;
import com.sicau.hls.springbootgraduationproject.dto.QueryEmployee;
import com.sicau.hls.springbootgraduationproject.user.entity.Employees;
import com.sicau.hls.springbootgraduationproject.user.mapper.EmployeesMapper;
import com.sicau.hls.springbootgraduationproject.user.service.EmployeesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

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
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements EmployeesService {
    @Autowired
    private EmployeesMapper employeesMapper;
    @Override
    public Employees getEmployeeInfo(EmployeeInfo employeeInfo) {
        QueryWrapper<Employees> wrapper = new QueryWrapper<>();
        wrapper.eq("employee_name",employeeInfo.getEmployeeName());

        return this.getOne(wrapper);
    }

    @Override
    public List<EmployeePerms> getEmployeePerms(Integer employeeId) {
        return employeesMapper.selectEmployeePerms(employeeId);
    }

    @Override
    public Page<Employees> getEmployeePage(QueryEmployee queryEmployee) {
        Page<Employees> page = new Page<>();
        page.setCurrent(queryEmployee.getCurrentPage());
        page.setSize(queryEmployee.getPageSize());
        QueryWrapper<Employees> wrapper = new QueryWrapper<>();
        if (queryEmployee.getEmployeeName() != null){
            wrapper.eq("employee_name",queryEmployee.getEmployeeName());
        }
        if (queryEmployee.getPassword()!=null){
            wrapper.eq("password",queryEmployee.getPassword());
        }
        return page(page,wrapper);
    }

    @Override
    public boolean addEmployee(EmployeeInfo employeeInfo) {
        Employees employees = new Employees();
        BeanUtils.copyProperties(employeeInfo,employees);
        return this.save(employees);
    }

    @Override
    public boolean updateEmployee(@RequestBody EmployeeInfo employeeInfo) {
        Employees employees = new Employees();
        BeanUtils.copyProperties(employeeInfo,employees);
        return this.updateById(employees);
    }

    @Override
    public boolean deleteEmployee(Integer employeeId) {
        return this.removeById(employeeId);
    }

    @Override
    public Page<Employees> getEmployeeLike(QueryEmployee queryEmployee) {
        Page<Employees> page = new Page<>();
        page.setCurrent(queryEmployee.getCurrentPage());
        page.setSize(queryEmployee.getPageSize());
        QueryWrapper<Employees> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(queryEmployee.getEmployeeName())){
            wrapper.like("employee_name",queryEmployee.getEmployeeName());
        }
        if (!StringUtils.isEmpty(queryEmployee.getPosition())){
            wrapper.eq("position",queryEmployee.getPosition());
        }
        if (!StringUtils.isEmpty(queryEmployee.getContactNumber())){
            wrapper.likeRight("contact_number",queryEmployee.getContactNumber());
        }
        if (!StringUtils.isEmpty(queryEmployee.getContactNumber()) && !StringUtils.isEmpty(queryEmployee.getEmployeeName())){
            wrapper.likeRight("contact_number",queryEmployee.getContactNumber()).like("employee_name",queryEmployee.getEmployeeName());
        }
        if (!StringUtils.isEmpty(queryEmployee.getContactNumber()) && !StringUtils.isEmpty(queryEmployee.getPosition())){
            wrapper.likeRight("contact_number",queryEmployee.getContactNumber()).eq("position",queryEmployee.getPosition());
        }
        if (!StringUtils.isEmpty(queryEmployee.getEmployeeName()) && !StringUtils.isEmpty(queryEmployee.getPosition())){
            wrapper.like("employee_name",queryEmployee.getEmployeeName()).eq("position",queryEmployee.getPosition());
        }

        if (!StringUtils.isEmpty(queryEmployee.getEmployeeName()) && !StringUtils.isEmpty(queryEmployee.getPosition()) && !StringUtils.isEmpty(queryEmployee.getContactNumber())){
            wrapper.like("employee_name",queryEmployee.getEmployeeName()).eq("position",queryEmployee.getPosition()).likeRight("contact_number",queryEmployee.getContactNumber());
        }


        return page(page,wrapper);
    }
}
