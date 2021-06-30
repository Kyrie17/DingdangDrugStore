package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.common.Constant;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.Category;
import com.dingdang.DingdangDrugstore.mbg.model.Product;
import com.dingdang.DingdangDrugstore.mbg.model.ProductDetail;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/2/28 19:50
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 添加商品
     */
    @RequestMapping(value = "/add_product",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addProduct(@RequestBody Product product) throws BusinessException {
        if (product == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        productService.addProduct(product);
        return CommonReturnType.create(product.getId());
    }

    /**
     * 添加商品详情
     */
    @RequestMapping(value = "/add_product_detail",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addProductDetail(@RequestBody ProductDetail productDetail) throws BusinessException {
        if (productDetail == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        productService.addProductDetail(productDetail);
        return CommonReturnType.create(null);
    }

    /**
     * 获取商品详情
     */
    @RequestMapping(value = "/get_product_detail",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getProductDetail(Long productId) throws BusinessException {
        if (productId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        ProductDetail productDetail = productService.getProductDetail(productId);
        return CommonReturnType.create(productDetail);
    }

    /**
     * 修改商品详情
     */
    @RequestMapping(value = "/update_product_detail",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateProductDetail(ProductDetail productDetail) throws BusinessException {
        if (productDetail == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        productService.updateProductDetail(productDetail);
        return CommonReturnType.create(null);
    }

    /**
     * 上传商品图片
     */
    @RequestMapping(value = "/upload_pic",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType uploadPic(@RequestParam("pic") MultipartFile pic) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (pic == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "图片不能为空");
        }
        String path =  productService.uploadPic(pic);
        return CommonReturnType.create(path);
    }

    /**
     * 依据条件获取商品列表
     */
    @RequestMapping(value = "/get_product",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getProduct(@RequestParam(value = "type", required = false) Integer type,
                                       @RequestParam(value = "brandId", required = false) Long brandId,
                                       @RequestParam(value = "productCategoryId", required = false) Long productCategoryId,
                                       @RequestParam(value = "name", required = false) String name,
                                       @RequestParam("pageNum") Integer pageNum) throws BusinessException {
        Integer pageSize = Constant.PAGESIZE;
        if (pageNum == null || pageSize == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "页码不能为空");
        }
        PageInfo<Product> pageInfo =  productService.getProductByCondition(type, brandId, productCategoryId, name, pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }

    /**
     * 依据id获取商品
     */
    @RequestMapping(value = "/get_product_by_id",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getProduct(@RequestParam(value = "productId") Long productId) throws BusinessException {
        if (productId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Product product =  productService.getProductById(productId);
        return CommonReturnType.create(product);
    }

    /**
     * 添加分类
     */
    @RequestMapping(value = "/add_category",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addCategory(Category category) throws BusinessException {
        if (category == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        productService.addCategory(category);
        return CommonReturnType.create(null);
    }

    /**
     * 查询所有商品分类
     */
    @RequestMapping(value = "/get_category",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getCategory(@RequestParam("pageNum") Integer pageNum) throws BusinessException {
        if (pageNum == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "页码不能为空");
        }
        Integer pageSize = Constant.PAGESIZE;
        PageInfo<Category> pageInfo = productService.getCategory(pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }

    /**
     * 修改商品状态
     */
    @RequestMapping(value = "/update_product_status",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateProductStatus(@RequestParam(name="productId")Long productId,
                                             @RequestParam(name="productPublishStatus")Boolean productPublishStatus) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (productId == null || productPublishStatus == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Product product = new Product();
        product.setId(productId);
        product.setPublishStatus(productPublishStatus);
        productService.updateStatusByUserId(product);
        return CommonReturnType.create(null);
    }

    /**
     * 删除用户信息
     */
    @RequestMapping(value = "/delete_product_by_id",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deleteUserById(@RequestParam(name="productId")Long productId) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (productId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        productService.deleteProductById(productId);
        return CommonReturnType.create(null);
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/update_product",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateProduct(@RequestBody Product product) throws BusinessException {

        if (product == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        productService.updateProduct(product);
        return CommonReturnType.create(null);
    }

    /**
     * 依据搜索条件获取商品
     */
    @RequestMapping(value = "/get_product_by_query",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType getProduct(@RequestParam(value = "query") String query) throws BusinessException {
        if (query == null || StringUtils.isEmpty(query)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        List<Product> productList =  productService.getProductByQeury(query);
        return CommonReturnType.create(productList);
    }
}
