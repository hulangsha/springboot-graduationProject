package com.sicau.hls.springbootgraduationproject.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.dto.EmployeeInfo;
import com.sicau.hls.springbootgraduationproject.dto.EmployeePerms;
import com.sicau.hls.springbootgraduationproject.dto.QueryEmployee;
import com.sicau.hls.springbootgraduationproject.user.entity.Employees;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
public interface EmployeesService extends IService<Employees> {
    Employees getEmployeeInfo(EmployeeInfo employeeInfo);
    List<EmployeePerms> getEmployeePerms(Integer employeeId);
    Page<Employees> getEmployeePage(QueryEmployee queryEmployee);
    boolean addEmployee(EmployeeInfo employeeInfo);
    boolean updateEmployee(EmployeeInfo employeeInfo);
    boolean deleteEmployee(Integer employeeId);
    Page<Employees> getEmployeeLike(QueryEmployee queryEmployee);
}
