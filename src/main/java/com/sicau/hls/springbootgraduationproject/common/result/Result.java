package com.sicau.hls.springbootgraduationproject.common.result;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //成功时返回的结果
    public Result<T> success(Integer code, String msg){
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> success(String msg){
        return success(200,msg);
    }
    public Result<T> success(){
        return success("操作成功");
    }

    public Result<T> put(T data){
        this.data = data;
        return this;
    }

    //失败时返回的结果
    public Result<T> error(Integer code,String msg){
        this.code = code;
        this.msg = msg;
        return this;
    }
    public Result<T> error(String msg){
        return error(500,msg);
    }
    public Result<T> error(){
        return error("操作失败");
    }

}
