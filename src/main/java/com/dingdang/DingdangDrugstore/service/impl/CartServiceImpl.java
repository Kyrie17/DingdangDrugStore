package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.mbg.mapper.CartItemMapper;
import com.dingdang.DingdangDrugstore.mbg.model.CartItem;
import com.dingdang.DingdangDrugstore.service.CartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/1 23:58
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartItemMapper cartItemMapper;

    @Override
    public List<CartItem> getItem(Long userId) {
        List<CartItem> cartItemList = cartItemMapper.getItemByUserId(userId);
        return cartItemList;
    }

    @Override
    public void deleteCartItem(Long userId, Long productId) {
        cartItemMapper.deleteByUserIdAndProductId(userId, productId);
    }

    @Override
    public void updateSelectAll(Long userId, Boolean allChecked) {
        cartItemMapper.updateSelectAll(userId, allChecked);
    }

    @Override
    public void updateCartItem(Long userId, Long productId, Integer quantity, Boolean checked) {
        CartItem cartItem = new CartItem();
        cartItem.setMemberId(userId);
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        cartItem.setChecked(checked);
        cartItemMapper.updateByUserIdAndProductIdSelective(cartItem);
    }

    @Override
    public void addItem(CartItem cartItem) {
        CartItem oldCartItem = cartItemMapper.getCartItemByUserIdAndProductId(cartItem.getMemberId(), cartItem.getProductId());
        if (oldCartItem == null) {
            // 加入购物车的时间
            Date currentTime = new Date();
            cartItem.setCreateDate(currentTime);
            cartItemMapper.insertSelective(cartItem);
        } else {
            cartItem.setQuantity(oldCartItem.getQuantity() + cartItem.getQuantity());
            cartItemMapper.updateByUserIdAndProductIdSelective(cartItem);
        }
    }
}
