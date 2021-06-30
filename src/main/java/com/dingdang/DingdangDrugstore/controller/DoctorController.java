package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.common.Constant;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.Doctor;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.DoctorService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/28 15:03
 */

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    /**
     * 获取订单
     */
    @RequestMapping(value = "/get_doctor",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getDoctor(@RequestParam(value = "doctorName", required = false) String doctorName,
                                     @RequestParam("pageNum") Integer pageNum) throws BusinessException {
        if (pageNum == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "页码不能为空");
        }
        Integer pageSize = Constant.PAGESIZE;
        PageInfo<Doctor> pageInfo = doctorService.getDoctorByCondition(doctorName, pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }
}
