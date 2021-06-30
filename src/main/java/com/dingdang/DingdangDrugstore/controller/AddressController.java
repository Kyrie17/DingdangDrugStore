package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.Address;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.AddressService;
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
 * @date 2021/4/5 20:52
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    /**
     * 添加收货地址
     */
    @RequestMapping(value = "/add_address",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addAddress(Address address) throws BusinessException {
        if (address == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        addressService.addAddress(address);
        return CommonReturnType.create(null);
    }

    /**
     * 获取收货地址
     */
    @RequestMapping(value = "/get_address",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getAddress(@RequestParam(value = "userId") Long userId) throws BusinessException {
        if (userId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        List<Address> addressList = addressService.getAddress(userId);
        return CommonReturnType.create(addressList);
    }

    /**
     * 更新收货地址
     */
    @RequestMapping(value = "/update_address",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateAddress(Address address) throws BusinessException {
        if (address == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        addressService.updateAddress(address);
        return CommonReturnType.create(null);
    }
    /**
     * 删除收货地址
     */
    @RequestMapping(value = "/delete_address",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deleteAddress(@RequestParam(value = "addressId")Long addressId) throws BusinessException {
        if (addressId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        addressService.deleteAddress(addressId);
        return CommonReturnType.create(null);
    }
}
