package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.mbg.mapper.AddressMapper;
import com.dingdang.DingdangDrugstore.mbg.model.Address;
import com.dingdang.DingdangDrugstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/5 20:53
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public void deleteAddress(Long addressId) {
        addressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public void updateAddress(Address address) {
        addressMapper.updateByPrimaryKey(address);
    }

    @Override
    public List<Address> getAddress(Long userId) {
        return addressMapper.selectByUserId(userId);
    }

    @Override
    public void addAddress(Address address) {
        addressMapper.insertSelective(address);
    }
}
