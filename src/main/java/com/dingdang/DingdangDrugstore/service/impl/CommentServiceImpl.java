package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.controller.viewobject.CommentVo;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.mapper.CommentMapper;
import com.dingdang.DingdangDrugstore.mbg.mapper.MemberMapper;
import com.dingdang.DingdangDrugstore.mbg.model.Comment;
import com.dingdang.DingdangDrugstore.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/1 8:20
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    MemberMapper memberMapper;

    @Override
    public Boolean hasComment(Long productId, Long orderId) {
        return commentMapper.countByOrderIdAndProductId(productId, orderId) > 0 ? false : true;
    }

    @Override
    public void addComment(Comment comment) throws BusinessException {
        Long userId = comment.getUserId();
        Long productId = comment.getProductId();
        if (userId == null || productId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        String userName = memberMapper.selectByPrimaryKey(userId).getUsername();
        comment.setUserName(userName);
        comment.setDate(new Date());
        commentMapper.insertSelective(comment);
    }

    @Override
    public PageInfo<CommentVo> getComment(Long productId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> commentList = commentMapper.selectByProductId(productId);
        List<CommentVo> commentVoList = convertToCommentVo(commentList);
        PageInfo<CommentVo> pageInfo = new PageInfo<CommentVo>(commentVoList);
        return pageInfo;
    }

    /**
     * 将Comment转换为CommentVO
     */
    private List<CommentVo> convertToCommentVo(List<Comment> commentList) {
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment: commentList) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(comment.getDate());
            CommentVo commentVo = new CommentVo();
            commentVo.setId(comment.getId());
            commentVo.setOrderId(comment.getOrderId());
            commentVo.setProductId(comment.getProductId());
            commentVo.setUserId(comment.getUserId());
            commentVo.setUserName(comment.getUserName());
            commentVo.setStar(comment.getStar());
            commentVo.setComment(comment.getComment());
            commentVo.setDate(dateStr);
            commentVoList.add(commentVo);
        }
        return commentVoList;
    }
}
