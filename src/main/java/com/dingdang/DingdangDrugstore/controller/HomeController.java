package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.HomeClassify;
import com.dingdang.DingdangDrugstore.mbg.model.HomeClassifyItem;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.HomeService;
import org.apache.commons.lang3.StringUtils;
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
 * @date 2021/4/15 18:43
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    /**
     * 添加首页展示分类
     */
    @RequestMapping(value = "/add_home_classify",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addHomeClassify(@RequestParam(value = "name") String name) throws BusinessException {
        if (name == null || StringUtils.isEmpty(name)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        homeService.addHomeClassify(name);
        return CommonReturnType.create(null);
    }

    /**
     * 添加首页展示分类商品
     */
    @RequestMapping(value = "/add_home_classify_item",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addHomeClassifyItem(@RequestParam(value = "homeClassifyId") Long homeClassifyId,
                                                @RequestParam(value = "productId") Long productId) throws BusinessException {
        if (homeClassifyId == null || productId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        homeService.addHomeClassifyItem(homeClassifyId, productId);
        return CommonReturnType.create(null);
    }

    /**
     * 获取首页展示分类
     */
    @RequestMapping(value = "/get_home_classify",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getHomeClassify() throws BusinessException {
        List<HomeClassify> homeClassifyList = homeService.getHomeClassify();
        return CommonReturnType.create(homeClassifyList);
    }

    /**
     * 获取首页展示分类商品
     */
    @RequestMapping(value = "/get_home_classify_item",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getHomeClassifyItem(@RequestParam(value = "homeClassifyId") Long homeClassifyId) throws BusinessException {
        if (homeClassifyId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        List<HomeClassifyItem> homeClassifyItemList = homeService.getHomeClassifyItem(homeClassifyId);
        return CommonReturnType.create(homeClassifyItemList);
    }
}
