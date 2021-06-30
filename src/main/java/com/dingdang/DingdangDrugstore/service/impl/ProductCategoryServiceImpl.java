package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.mbg.mapper.ProductCategoryMapper;
import com.dingdang.DingdangDrugstore.mbg.model.Member;
import com.dingdang.DingdangDrugstore.mbg.model.ProductCategory;
import com.dingdang.DingdangDrugstore.service.ProductCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/13 15:13
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> getProductCategory() {
        return productCategoryMapper.selectAll();
    }

    @Override
    public void updateStatusByProductCategoryId(ProductCategory productCategory) {
        productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

    @Override
    public void updateProductCategory(ProductCategory productCategory) {
        productCategoryMapper.updateByPrimaryKeySelective(productCategory);
    }

    @Override
    public void deleteProductCategoryById(Long productCategoryId) {
        productCategoryMapper.deleteByPrimaryKey(productCategoryId);
    }

    @Override
    public PageInfo<ProductCategory> getProductCategoryList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectAll();
        //通过构造PageInfo对象获取分页信息，如当前页码，总页数，总条数
        PageInfo<ProductCategory> pageInfo = new PageInfo<ProductCategory>(productCategoryList);
        return pageInfo;
    }

    @Override
    public ProductCategory getProductCategoryById(Long productCategoryId) {
        return productCategoryMapper.selectByPrimaryKey(productCategoryId);
    }
}
