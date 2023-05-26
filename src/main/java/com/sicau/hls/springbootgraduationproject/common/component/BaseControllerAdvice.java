package com.sicau.hls.springbootgraduationproject.common.component;

import com.sicau.hls.springbootgraduationproject.common.result.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseControllerAdvice {
    @ExceptionHandler(value = UnauthorizedException.class)
    public Result<?> unAuthorize(UnauthorizedException e){
        return new Result<>().error(401,"没有操作权限");
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> exceptionResponse(Exception e){
        return new Result<>().error(500,"服务器内部错误");
    }
}
