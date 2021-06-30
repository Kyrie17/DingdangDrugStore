package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.mbg.model.Brand;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/13 11:56
 */
@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    /**
     * 获取所有的品牌
     */
    @RequestMapping(value = "/get_brand",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getBrand() {
        List<Brand> brandList = brandService.getBrandList();
        return CommonReturnType.create(brandList);
    }

    /**
     * 获取所有的品牌
     */
    @RequestMapping(value = "/get_brand_by_id",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getBrandById(@RequestParam("brandId") Long brandId) {
        Brand brand = brandService.getBrandById(brandId);
        return CommonReturnType.create(brand);
    }
}
