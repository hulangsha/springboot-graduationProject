package com.sicau.hls.springbootgraduationproject.user.mapper;

import com.sicau.hls.springbootgraduationproject.dto.EmployeePerms;
import com.sicau.hls.springbootgraduationproject.user.entity.Employees;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
public interface EmployeesMapper extends BaseMapper<Employees> {
    List<EmployeePerms> selectEmployeePerms(Integer employeeId);

}
