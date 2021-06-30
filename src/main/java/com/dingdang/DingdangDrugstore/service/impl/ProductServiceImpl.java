package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.common.MultipartFileToFile;
import com.dingdang.DingdangDrugstore.common.TencentUploadUtil;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.mapper.CategoryMapper;
import com.dingdang.DingdangDrugstore.mbg.mapper.ProductDetailMapper;
import com.dingdang.DingdangDrugstore.mbg.mapper.ProductMapper;
import com.dingdang.DingdangDrugstore.mbg.model.Category;
import com.dingdang.DingdangDrugstore.mbg.model.Member;
import com.dingdang.DingdangDrugstore.mbg.model.Product;
import com.dingdang.DingdangDrugstore.mbg.model.ProductDetail;
import com.dingdang.DingdangDrugstore.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/2/28 19:53
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductDetailMapper productDetailMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public PageInfo<Product> getProductByCondition(Integer type, Long brandId,
                                                   Long productCategoryId, String name,
                                                   int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectByCondition(type, brandId, productCategoryId, name);
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        return pageInfo;
    }

    @Override
    public PageInfo<Category> getCategory(Integer pageNum, Integer pageSize) throws BusinessException {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categoryList = categoryMapper.selectAllCategory();
        PageInfo<Category> pageInfo = new PageInfo<Category>(categoryList);
        return pageInfo;
    }

    @Override
    public void updateStatusByUserId(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List<Product> getProductByQeury(String query) {
        return productMapper.selectByQuery(query);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public Product getProductById(Long productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public void addCategory(Category category) throws BusinessException {
        try{
            categoryMapper.insert(category);
        }catch(DuplicateKeyException ex){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"分类重复添加");
        }
    }

    @Override
    public void addProductDetail(ProductDetail productDetail) throws BusinessException {
        try {
            productDetailMapper.insertSelective(productDetail);
        } catch (DuplicateKeyException ex) {
            throw new BusinessException(EmBusinessError.PRODUCT_EXISTED);
        }
    }

    @Override
    public ProductDetail getProductDetail(Long productId) {
        return productDetailMapper.selectByProductId(productId);
    }

    @Override
    public void updateProductDetail(ProductDetail productDetail) throws BusinessException {
        productDetailMapper.updateByProductIdSelective(productDetail);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insertSelective(product);
    }

    @Override
    public String uploadPic(MultipartFile file) {
        String storeDir = "dingdang_drugstore/product/";
        File pic = MultipartFileToFile.multipartFileToFile(file);
        String path = TencentUploadUtil.uploadFile(storeDir + pic.getName(), pic);
        return path;
    }
}
