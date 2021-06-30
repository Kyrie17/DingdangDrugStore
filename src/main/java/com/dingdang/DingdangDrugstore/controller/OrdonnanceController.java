package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.common.Constant;
import com.dingdang.DingdangDrugstore.controller.viewobject.OrdonnanceVo;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.Ordonnance;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.OrdonnanceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/7 2:27
 */
@Controller
@RequestMapping("/ordonnance")
public class OrdonnanceController {

    @Autowired
    OrdonnanceService ordonnanceService;

    /**
     * 添加商品
     */
    @RequestMapping(value = "/add_ordonnance",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addProduct(Ordonnance ordonnance) throws BusinessException {
        if (ordonnance == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        ordonnanceService.addOrdonnance(ordonnance);
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
        String path =  "http://" + ordonnanceService.uploadPic(pic);
        return CommonReturnType.create(path);
    }

    /**
     * 查询所有商品分类
     */
    @RequestMapping(value = "/check_buy",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getCategory(@RequestParam("userId") Long userId,
                                        @RequestParam("productId") Long productId) throws BusinessException {
        if (userId == null || productId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Boolean flag = ordonnanceService.checkBuy(userId, productId);
        return CommonReturnType.create(flag);
    }

    /**
     * 查询所有处方单
     */
    @RequestMapping(value = "/get_ordonnance",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getOrdonnance(@RequestParam("pageNum") Integer pageNum )throws BusinessException {
        if (pageNum == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Integer pageSize = Constant.PAGESIZE;
        PageInfo<OrdonnanceVo> pageInfo = ordonnanceService.getOrdonnance(pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }

    /**
     * 更新处方单状态
     */
    @RequestMapping(value = "/update_ordonnance_status",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateOrdonnanceStatus(@RequestParam("ordonnanceId") Long ordonnanceId,
                                       @RequestParam("status") Boolean status) throws BusinessException {
        if (ordonnanceId == null || status == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        ordonnanceService.updateOrdonnanceStatus(ordonnanceId, status);
        return CommonReturnType.create(null);
    }
}
