package com.sicau.hls.springbootgraduationproject.shiro;

import com.sicau.hls.springbootgraduationproject.common.component.JwtComponent;
import com.sicau.hls.springbootgraduationproject.dto.CustomerInfo;
import com.sicau.hls.springbootgraduationproject.dto.EmployeeInfo;
import com.sicau.hls.springbootgraduationproject.dto.EmployeePerms;
import com.sicau.hls.springbootgraduationproject.user.entity.Customers;
import com.sicau.hls.springbootgraduationproject.user.entity.Employees;
import com.sicau.hls.springbootgraduationproject.user.service.CustomersService;
import com.sicau.hls.springbootgraduationproject.user.service.EmployeesService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private JwtComponent jwtComponent;
    @Autowired
    private EmployeesService employeesService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Employees employees = (Employees) principalCollection.getPrimaryPrincipal();
        if (Objects.isNull(employees)){
            throw new AuthorizationException();
        }
        int employeeId = employees.getEmployeeId();
        if (Objects.isNull(employeeId)){
            throw new AuthorizationException();
        }
        List<EmployeePerms> employeesList = employeesService.getEmployeePerms(employeeId);
        if(CollectionUtils.isEmpty(employeesList)){
            throw new AuthorizationException();
        }
        Set<String > perms = new HashSet<>();
        Set<String > roles = new HashSet<>();
        for (EmployeePerms employeePerms : employeesList) {
            roles.add(employeePerms.getRoleCode());
            perms.add(employeePerms.getPermsCode());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(perms);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getPrincipal().toString();
        String userName = jwtComponent.getUserName(token);
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployeeName(userName);
        Employees employees = employeesService.getEmployeeInfo(employeeInfo);

        if (Objects.isNull(employees)){
            throw new AuthenticationException();
        }

            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employees, token, this.getName());
            return info;


    }

    /**
     * 支持Token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
}
