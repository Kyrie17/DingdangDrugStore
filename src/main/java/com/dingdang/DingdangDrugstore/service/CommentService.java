package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.controller.viewobject.CommentVo;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.mbg.model.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {

    /**
     * 获取商品评价
     */
    PageInfo<CommentVo> getComment(Long productId, Integer pageNum, Integer pageSize);

    /**
     * 添加商品评价
     * @param comment
     */
    void addComment(Comment comment) throws BusinessException;

    Boolean hasComment(Long productId, Long orderId);
}
