package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.mbg.mapper.DoctorMapper;
import com.dingdang.DingdangDrugstore.mbg.model.Doctor;
import com.dingdang.DingdangDrugstore.mbg.model.Order;
import com.dingdang.DingdangDrugstore.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/28 15:04
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public PageInfo<Doctor> getDoctorByCondition(String doctorName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> doctorList = doctorMapper.selectDoctorByCondition(doctorName);
        PageInfo<Doctor> pageInfo = new PageInfo<Doctor>(doctorList);
        return pageInfo;
    }
}
