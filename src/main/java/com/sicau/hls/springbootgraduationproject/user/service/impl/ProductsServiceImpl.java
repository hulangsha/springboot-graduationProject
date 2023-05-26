package com.sicau.hls.springbootgraduationproject.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.hls.springbootgraduationproject.dto.ProductInfo;
import com.sicau.hls.springbootgraduationproject.dto.QueryProduct;
import com.sicau.hls.springbootgraduationproject.user.entity.Products;
import com.sicau.hls.springbootgraduationproject.user.mapper.ProductsMapper;
import com.sicau.hls.springbootgraduationproject.user.service.ProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 胡浪沙：2023/4/20
 * @since 2023-04-24
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {
    @Override
    public Page<Products> getProductPage(QueryProduct queryProduct) {
        Page<Products> page = new Page<>();
        page.setCurrent(queryProduct.getCurrentPage());
        page.setSize(queryProduct.getPageSize());
        QueryWrapper<Products> wrapper = new QueryWrapper<>();
        return page(page,wrapper);
    }

    @Override
    public Page<Products> getProductSearch(QueryProduct queryProduct) {
        Page<Products> page = new Page<>();
        page.setCurrent(queryProduct.getCurrentPage());
        page.setSize(queryProduct.getPageSize());
        QueryWrapper<Products> wrapper = new QueryWrapper<>();
        if (queryProduct.getSupplierId() != null && queryProduct.getProductName() == ""){
            wrapper.eq("supplier_id",queryProduct.getSupplierId());
        }
        if (queryProduct.getProductId() == null && queryProduct.getProductName() != ""){
            wrapper.eq("product_name",queryProduct.getProductName());
        }
        if (queryProduct.getProductId() != null && queryProduct.getProductName() != ""){
            wrapper.eq("product_name",queryProduct.getProductName()).eq("supplier_id",queryProduct.getSupplierId());
        }
        return page(page,wrapper);
    }

    @Override
    public boolean getProductAdd(ProductInfo productInfo) {
        Products products = new Products();
        BeanUtils.copyProperties(productInfo,products);
        return this.save(products);
    }

    @Override
    public boolean getProductUpdate(ProductInfo productInfo) {
        Products products = new Products();
        BeanUtils.copyProperties(productInfo,products);
        return this.updateById(products);
    }

    @Override
    public boolean getProductDelete(Integer productId) {
        return this.removeById(productId);
    }
}
