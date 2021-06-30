package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.mbg.model.Address;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/5 20:53
 */
public interface AddressService {

    /**
     * 添加用户收货地址
     */
    void addAddress(Address address);

    /**
     * 获取用户地址列表
     */
    List<Address> getAddress(Long userId);

    /**
     * 修改用户收货地址信息
     */
    void updateAddress(Address address);

    /**
     * 删除用户收货地址
     */
    void deleteAddress(Long addressId);
}
