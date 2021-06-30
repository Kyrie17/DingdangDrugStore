package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.controller.viewobject.OrdonnanceVo;
import com.dingdang.DingdangDrugstore.mbg.model.Ordonnance;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

public interface OrdonnanceService {

    /**
     * 添加处方单
     */
    void addOrdonnance(Ordonnance ordonnance);

    String uploadPic(MultipartFile pic);

    Boolean checkBuy(Long userId, Long productId);

    PageInfo<OrdonnanceVo> getOrdonnance(Integer pageNum, Integer pageSize);

    void updateOrdonnanceStatus(Long ordonnanceId, Boolean status);
}
