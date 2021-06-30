package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.common.Constant;
import com.dingdang.DingdangDrugstore.controller.viewobject.CommentVo;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.Comment;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/1 8:19
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * 获取商品评价
     */
    @RequestMapping(value = "/get_comment",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getComment(@RequestParam(value = "productId")Long productId,
                                       @RequestParam(value = "pageNum" ) Integer pageNum) throws BusinessException {
        if (productId == null || pageNum == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Integer pageSize = Constant.PAGESIZE;
        PageInfo<CommentVo> pageInfo = commentService.getComment(productId, pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }

    /**
     * 添加评论
     */
    @RequestMapping(value = "/add_comment",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addComment(@RequestBody Comment comment) throws BusinessException {
        if (comment == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        commentService.addComment(comment);
        return CommonReturnType.create(null);
    }

    /**
     * 获取商品评价
     */
    @RequestMapping(value = "/has_comment",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType hasComment(@RequestParam(value = "productId")Long productId,
                                       @RequestParam(value = "orderId" ) Long orderId) throws BusinessException {
        if (productId == null || orderId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Boolean flag = commentService.hasComment(productId, orderId);
        return CommonReturnType.create(flag);
    }
}
