package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.mbg.mapper.BrandMapper;
import com.dingdang.DingdangDrugstore.mbg.model.Brand;
import com.dingdang.DingdangDrugstore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/13 11:58
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public Brand getBrandById(Long brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public List<Brand> getBrandList() {
         return brandMapper.selectAll();
    }
}
