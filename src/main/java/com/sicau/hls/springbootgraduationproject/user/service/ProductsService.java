package com.sicau.hls.springbootgraduationproject.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.dto.ProductInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryProduct;
import com.sicau.hls.springbootgraduationproject.user.entity.Products;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
public interface ProductsService extends IService<Products> {
    Page<Products> getProductPage(QueryProduct queryProduct);
    Page<Products> getProductSearch(QueryProduct queryProduct);
    boolean getProductAdd(ProductInfo productInfo);
    boolean getProductUpdate(ProductInfo productInfo);
    boolean getProductDelete(Integer productId);
}
