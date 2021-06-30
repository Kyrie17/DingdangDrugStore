package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.mbg.model.Doctor;
import com.github.pagehelper.PageInfo;

public interface DoctorService {

    PageInfo<Doctor> getDoctorByCondition(String doctorName, int pageNum, int pageSize);
}
