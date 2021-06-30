package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.mbg.mapper.HomeClassifyItemMapper;
import com.dingdang.DingdangDrugstore.mbg.mapper.HomeClassifyMapper;
import com.dingdang.DingdangDrugstore.mbg.mapper.ProductMapper;
import com.dingdang.DingdangDrugstore.mbg.model.HomeClassify;
import com.dingdang.DingdangDrugstore.mbg.model.HomeClassifyItem;
import com.dingdang.DingdangDrugstore.mbg.model.Product;
import com.dingdang.DingdangDrugstore.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/15 18:44
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeClassifyMapper homeClassifyMapper;

    @Autowired
    HomeClassifyItemMapper homeClassifyItemMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public void addHomeClassifyItem(Long homeClassifyId, Long productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        HomeClassifyItem homeClassifyItem = new HomeClassifyItem();
        homeClassifyItem.setHomeClassifyId(homeClassifyId);
        homeClassifyItem.setProductId(productId);
        homeClassifyItem.setName(product.getName());
        homeClassifyItem.setPrice(product.getPrice());
        homeClassifyItem.setSubTitle(product.getSubTitle());
        homeClassifyItem.setPic(product.getPic());
        homeClassifyItemMapper.insertSelective(homeClassifyItem);
    }

    @Override
    public void addHomeClassify(String name) {
        HomeClassify homeClassify = new HomeClassify();
        homeClassify.setName(name);
        homeClassifyMapper.insertSelective(homeClassify);
    }

    @Override
    public List<HomeClassify> getHomeClassify() {
        return homeClassifyMapper.selectAll();
    }

    @Override
    public List<HomeClassifyItem> getHomeClassifyItem(Long homeClassifyId) {
        return homeClassifyItemMapper.getHomeClassifyItemByHomeClassifyId(homeClassifyId);
    }
}
