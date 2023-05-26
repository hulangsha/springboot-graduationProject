package com.sicau.hls.springbootgraduationproject.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.common.component.JwtComponent;
import com.sicau.hls.springbootgraduationproject.common.result.PageResult;
import com.sicau.hls.springbootgraduationproject.common.result.Result;
import com.sicau.hls.springbootgraduationproject.dto.EmployeeInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryEmployee;
import com.sicau.hls.springbootgraduationproject.user.entity.Employees;
import com.sicau.hls.springbootgraduationproject.user.service.EmployeesService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/employee")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private JwtComponent jwtComponent;
    @RequestMapping("/login")
    public Result<?> login(@RequestBody EmployeeInfo employeeInfo){
        Employees employees = employeesService.getEmployeeInfo(employeeInfo);
        if (Objects.isNull(employees)){
            return new Result<>().error();
        }
        String token = jwtComponent.sign(employeeInfo.getEmployeeName(), employeeInfo.getPassword());
        JSONObject object = new JSONObject();
        object.put("token",token);
        object.put("employee",employees);
        return new Result<>().success().put(object);
    }

    @GetMapping("/page")
    @RequiresRoles(value = "admin")
    public PageResult<?> getEmployeePage(QueryEmployee queryEmployee){
        Page<Employees> employeesPage = employeesService.getEmployeePage(queryEmployee);
        PageResult<Employees> result = new PageResult<>(employeesPage.getCurrent(), employeesPage.getSize(), employeesPage.getTotal(), employeesPage.getPages(), employeesPage.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    @PostMapping("/add")
    public Result<?> addEmployee(@RequestBody EmployeeInfo employeeInfo){
        boolean result = employeesService.addEmployee(employeeInfo);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @PostMapping("/update")
    public Result<?> updateEmployee(@RequestBody  EmployeeInfo employeeInfo){
        boolean result = employeesService.updateEmployee(employeeInfo);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @GetMapping("/delete")
    public Result<?> deleteEmployee(Integer employeeId){
        boolean result = employeesService.deleteEmployee(employeeId);
        if(result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @PostMapping("/search")
    public PageResult<?> searchEmployeeLike(QueryEmployee queryEmployee){
        Page<Employees> employeesPage = employeesService.getEmployeeLike(queryEmployee);
        PageResult<Employees> result = new PageResult<>(employeesPage.getCurrent(), employeesPage.getSize(), employeesPage.getTotal(), employeesPage.getPages(), employeesPage.getRecords());
        result.setCode(200);
        result.setMsg("操作成功");
        return result;
    }

    @GetMapping("/401")
    public Result<?> unAuthorizationResponse(){
        return new Result<>().error(401,"用户没有操作权限");
    }
}
