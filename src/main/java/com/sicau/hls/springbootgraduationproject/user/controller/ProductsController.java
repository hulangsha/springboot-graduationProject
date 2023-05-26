package com.sicau.hls.springbootgraduationproject.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.common.result.PageResult;
import com.sicau.hls.springbootgraduationproject.common.result.Result;
import com.sicau.hls.springbootgraduationproject.dto.ProductInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryProduct;
import com.sicau.hls.springbootgraduationproject.user.entity.Products;
import com.sicau.hls.springbootgraduationproject.user.service.ProductsService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/api/product")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @GetMapping("/page")
    @RequiresRoles(value = {"admin","staff"},logical = Logical.OR)
    public PageResult<?> getProductPage(QueryProduct queryProduct){
        Page<Products> page = productsService.getProductPage(queryProduct);
        PageResult<Products> pageResult = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        pageResult.setCode(200);
        pageResult.setMsg("操作成功");
        return pageResult;
    }
    @GetMapping("/search")
    public PageResult<?> getProductSearch(QueryProduct queryProduct){
        Page<Products> page = productsService.getProductSearch(queryProduct);
        PageResult<Products> pageResult = new PageResult<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getPages(),page.getRecords());
        pageResult.setCode(200);
        pageResult.setMsg("操作成功");
        return pageResult;
    }

    @PostMapping("/add")
    public Result<?> getProductAdd(@RequestBody ProductInfo productInfo){
        boolean result = productsService.getProductAdd(productInfo);
        if(result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @PostMapping("/update")
    public Result<?> getProductUpdate(@RequestBody ProductInfo productInfo){
        boolean result = productsService.getProductUpdate(productInfo);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }

    @PostMapping("/delete")
    public Result<?> getProductDelete(Integer productId){
        boolean result = productsService.getProductDelete(productId);
        if (result){
            return new Result<>().success().put(result);
        }else {
            return new Result<>().error();
        }
    }
}
