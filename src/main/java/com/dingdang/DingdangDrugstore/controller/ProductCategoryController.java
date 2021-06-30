package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.common.Constant;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.ProductCategory;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.ProductCategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/13 14:56
 */
@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    /**
     * 获取所有的商品分类
     */
    @RequestMapping(value = "/get_product_category",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getProductCategory() {
        List<ProductCategory> productCategoryList = productCategoryService.getProductCategory();
        return CommonReturnType.create(productCategoryList);
    }

    /**
     * 获取所有的商品分类
     */
    @RequestMapping(value = "/get_product_category_list",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getProductCategoryList(@RequestParam("pageNum") Integer pageNum) {
        Integer pageSize = Constant.PAGESIZE;
        PageInfo<ProductCategory> pageInfo = productCategoryService.getProductCategoryList(pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }

    /**
     * 通过商品分类id获取商品分类信息
     */
    @RequestMapping(value = "/get_product_category_by_id",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getProductCategoryById(@RequestParam("productCategoryId") Long productCategoryId) {
        ProductCategory productCategory = productCategoryService.getProductCategoryById(productCategoryId);
        return CommonReturnType.create(productCategory);
    }

    /**
     * 修改商品分类状态
     */
    @RequestMapping(value = "/update_product_category_status",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateProductStatus(@RequestParam(name="productCategoryId")Long productCategoryId,
                                                @RequestParam(name="productCategoryStatus")Boolean productCategoryStatus) throws BusinessException {

        if (productCategoryId == null || productCategoryStatus == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryId);
        productCategory.setShowStatus(productCategoryStatus);
        productCategoryService.updateStatusByProductCategoryId(productCategory);
        return CommonReturnType.create(null);
    }

    /**
     * 删除药品分类
     */
    @RequestMapping(value = "/delete_product_category_by_id",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deleteProductCategoryById(@RequestParam(name="productCategoryId")Long productCategoryId) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (productCategoryId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        productCategoryService.deleteProductCategoryById(productCategoryId);
        return CommonReturnType.create(null);
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/update_product_category",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateProduct(@RequestBody ProductCategory productCategory) throws BusinessException {

        if (productCategory == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        productCategoryService.updateProductCategory(productCategory);
        return CommonReturnType.create(null);
    }
}
