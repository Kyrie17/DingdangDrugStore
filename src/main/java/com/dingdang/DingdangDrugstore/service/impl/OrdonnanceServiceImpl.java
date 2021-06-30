package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.common.MultipartFileToFile;
import com.dingdang.DingdangDrugstore.common.TencentUploadUtil;
import com.dingdang.DingdangDrugstore.controller.viewobject.OrdonnanceVo;
import com.dingdang.DingdangDrugstore.mbg.mapper.MemberMapper;
import com.dingdang.DingdangDrugstore.mbg.mapper.OrdonnanceMapper;
import com.dingdang.DingdangDrugstore.mbg.mapper.ProductMapper;
import com.dingdang.DingdangDrugstore.mbg.model.Ordonnance;
import com.dingdang.DingdangDrugstore.mbg.model.Product;
import com.dingdang.DingdangDrugstore.service.OrdonnanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/7 2:28
 */
@Service
public class OrdonnanceServiceImpl implements OrdonnanceService {

    @Autowired
    OrdonnanceMapper ordonnanceMapper;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public PageInfo<OrdonnanceVo> getOrdonnance(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Ordonnance> ordonnanceList = ordonnanceMapper.getAllOrdonnance();
        List<OrdonnanceVo> ordonnanceVoList = convertToOrdonnanceVo(ordonnanceList);
        PageInfo<OrdonnanceVo> pageInfo = new PageInfo<OrdonnanceVo>(ordonnanceVoList);
        return pageInfo;
    }

    @Override
    public Boolean checkBuy(Long userId, Long productId) {
        Ordonnance ordonnance = ordonnanceMapper.selectByUserIdAndProductId(userId, productId);
        return ordonnance.getStatus();
    }

    @Override
    public String uploadPic(MultipartFile file) {
        String storeDir = "dingdang_drugstore/ordonnance/";
        File pic = MultipartFileToFile.multipartFileToFile(file);
        String path = TencentUploadUtil.uploadFile(storeDir + pic.getName(), pic);
        return path;
    }

    @Override
    public void addOrdonnance(Ordonnance ordonnance) {
        ordonnance.setStatus(false);
        ordonnanceMapper.insertSelective(ordonnance);
    }

    @Override
    public void updateOrdonnanceStatus(Long ordonnanceId, Boolean status) {
        Ordonnance ordonnance = new Ordonnance();
        ordonnance.setId(ordonnanceId);
        ordonnance.setStatus(status);
        ordonnanceMapper.updateByPrimaryKeySelective(ordonnance);
    }

    private List<OrdonnanceVo> convertToOrdonnanceVo(List<Ordonnance> ordonnanceList) {
        List<OrdonnanceVo> ordonnanceVoList = new ArrayList<>();
        for (Ordonnance ordonnance: ordonnanceList) {
            OrdonnanceVo ordonnanceVo = new OrdonnanceVo();
            ordonnanceVo.setUserName(memberMapper.selectByPrimaryKey(ordonnance.getUserId()).getUsername());
            Product product = productMapper.selectByPrimaryKey(ordonnance.getProductId());
            ordonnanceVo.setProductSn(product.getProductSn());
            ordonnanceVo.setProductName(product.getName());
            ordonnanceVo.setId(ordonnance.getId());
            ordonnanceVo.setOrdonnance(ordonnance.getOrdonnance());
            ordonnanceVo.setDisease(ordonnance.getDisease());
            ordonnanceVo.setStatus(ordonnance.getStatus());
            ordonnanceVoList.add(ordonnanceVo);
        }
        return ordonnanceVoList;
    }
}
