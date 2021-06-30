package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.mbg.model.CartItem;
import com.dingdang.DingdangDrugstore.mbg.model.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CartService {

    /**
     * 添加商品至购物车
     */
    void addItem(CartItem cartItem);

    /**
     * 获取用户购物车中所有商品
     */
    List<CartItem> getItem(Long userId);

    /**
     * 添加商品至购物车
     */
    void updateCartItem(Long userId, Long productId, Integer quantity, Boolean checked);

    /**
     * 更新全选
     */
    void updateSelectAll(Long userId, Boolean allChecked);

    /**
     * 删除购物车商品
     */
    void deleteCartItem(Long userId, Long productId);
}
