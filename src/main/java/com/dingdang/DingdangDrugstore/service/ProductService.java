package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.mbg.model.Category;
import com.dingdang.DingdangDrugstore.mbg.model.Product;
import com.dingdang.DingdangDrugstore.mbg.model.ProductDetail;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    /**
     * 上传图片至腾讯云对象存储中
     */
    String uploadPic(MultipartFile pic);

    /**
     * 添加商品
     */
    void addProduct(Product product);

    /**
     * 添加商品详情
     */
    void addProductDetail(ProductDetail productDetail) throws BusinessException;

    /**
     * 获取商品详情
     */
    ProductDetail getProductDetail(Long productId);

    /**
     * 更新商品详情
     */
    void updateProductDetail(ProductDetail productDetail) throws BusinessException;

    /**
     * 按搜索条件查询商品
     */
    PageInfo<Product> getProductByCondition(Integer type, Long brandId,
                                            Long productCategoryId, String name,
                                            int pageNum, int pageSize);

    /**
     * 添加商品分类
     */
    void addCategory(Category category) throws BusinessException;

    /**
     * 获得所有商品分类
     */
    PageInfo<Category> getCategory(Integer pageNum, Integer pageSize) throws BusinessException;

    // 更新用户状态
    void updateStatusByUserId(Product product);

    /**
     * 依据id获取商品
     */
    Product getProductById(Long productId);

    /**
     * 删除商品
     */
    void deleteProductById(Long productId);

    /**
     * 更新商品
     */
    void updateProduct(Product product);

    /**
     *
     * @param query
     * @return
     */
    List<Product> getProductByQeury(String query);
}
