package com.dingdang.DingdangDrugstore.controller.viewobject;

import com.dingdang.DingdangDrugstore.mbg.model.CartItem;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/2 23:34
 */
public class CartItemList {

    List<CartItem> cartItemList;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
