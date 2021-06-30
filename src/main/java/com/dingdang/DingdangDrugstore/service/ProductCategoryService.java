package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.mbg.model.ProductCategory;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductCategoryService {

    // 获取所有的商品分类
    List<ProductCategory> getProductCategory();

    // 获取所有的商品分类
    PageInfo<ProductCategory> getProductCategoryList(int pageNum, int pageSize);

    // 根据商品分类id获取商品分类
    ProductCategory getProductCategoryById(Long productCategoryId);

    // 更新商品分类状态
    void updateStatusByProductCategoryId(ProductCategory productCategory);

    // 依据商品分类id删除商品分类
    void deleteProductCategoryById(Long productCategoryId);

    // 修改商品分类信息
    void updateProductCategory(ProductCategory productCategory);
}
