package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.mbg.model.HomeClassify;
import com.dingdang.DingdangDrugstore.mbg.model.HomeClassifyItem;

import java.util.List;

public interface HomeService {
    /**
     * 添加首页分类
     */
    void addHomeClassify(String name);

    /**
     * 添加首页分类商品
     */
    void addHomeClassifyItem(Long homeClassifyId, Long productId);

    /**
     * 获取首页商品分类
     */
    List<HomeClassify> getHomeClassify();

    /**
     * 获取首页商品分类商品
     */
    List<HomeClassifyItem> getHomeClassifyItem(Long homeClassifyId);
}
