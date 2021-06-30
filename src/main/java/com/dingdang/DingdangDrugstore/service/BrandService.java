package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.mbg.model.Brand;

import java.util.List;

public interface BrandService {

    // 获取品牌列表
    List<Brand> getBrandList();

    // 通过brandid获取品牌
    Brand getBrandById(Long brandId);
}
