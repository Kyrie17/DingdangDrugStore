package com.dingdang.DingdangDrugstore.controller;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/1 23:57
 */

import com.dingdang.DingdangDrugstore.common.UserLoginToken;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.CartItem;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    HttpServletRequest httpServletRequest;

    /**
     * 添加商品至购物车
     */
    @RequestMapping(value = "/add_item",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addItem(CartItem cartItem) throws BusinessException {
        if (cartItem == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        cartService.addItem(cartItem);
        return CommonReturnType.create(null);
    }

    /**
     * 获取用户的购物车商品
     */
//    @RequestMapping(value = "/get_item",method = {RequestMethod.GET})
//    @ResponseBody
//    public CommonReturnType getItem(Long userId, Integer pageNum) throws BusinessException {
//        if (userId == null) {
//            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "请登录！");
//        }
//        Integer pageSize = Constant.PAGESIZE;
//        PageInfo<CartItem> pageInfo =  cartService.getItem(userId, pageNum, pageSize);
//        return CommonReturnType.create(pageInfo);
//    }

    /**
     * 获取用户的购物车商品
     */
    @UserLoginToken
    @RequestMapping(value = "/get_item",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(value = "userId") Long userId) throws BusinessException {
        List<CartItem> cartItemList =  cartService.getItem(userId);
        return CommonReturnType.create(cartItemList);
    }

    /**
     * 修改购物车勾选状态
     */
    @RequestMapping(value = "/update_cart_item",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateCartItem(@RequestParam(value = "userId") Long userId,
                                           @RequestParam(value = "productId") Long productId,
                                           @RequestParam(value = "quantity") Integer quantity,
                                           @RequestParam(value = "checked") Boolean checked) throws BusinessException {
        if (userId == null || productId == null || quantity == null || checked == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        cartService.updateCartItem(userId, productId, quantity, checked);
        return CommonReturnType.create(null);
    }

    /**
     * 全选
     */
    @RequestMapping(value = "/update_select_all",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateSelectAll(@RequestParam(value = "userId") Long userId,
                                      @RequestParam(value = "allChecked") Boolean allChecked) throws BusinessException {
        if (userId == null || allChecked == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        cartService.updateSelectAll(userId, allChecked);
        return CommonReturnType.create(null);
    }

    /**
     * 删除购物车商品
     */
    @RequestMapping(value = "/delete_cart_item",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deleteCartItem(@RequestParam(value = "userId") Long userId,
                                            @RequestParam(value = "productId") Long productId) throws BusinessException {
        if (userId == null || productId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        cartService.deleteCartItem(userId, productId);
        return CommonReturnType.create(null);
    }
}
