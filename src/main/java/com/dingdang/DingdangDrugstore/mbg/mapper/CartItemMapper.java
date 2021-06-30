package com.dingdang.DingdangDrugstore.mbg.mapper;

import com.dingdang.DingdangDrugstore.mbg.model.CartItem;
import com.dingdang.DingdangDrugstore.mbg.model.CartItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartItemMapper {
    int countByExample(CartItemExample example);

    int deleteByExample(CartItemExample example);

    int deleteByPrimaryKey(Long id);

    int deleteByUserIdAndProductId(@Param("memberId") Long memberId, @Param("productId") Long productId);

    int insert(CartItem record);

    int insertSelective(CartItem record);

    List<CartItem> selectByExample(CartItemExample example);

    List<CartItem> getItemByUserId(@Param("memberId") Long memberId);

    List<CartItem> getCheckedItemByUserId(@Param("memberId") Long memberId);

    CartItem getCartItemByUserIdAndProductId(@Param("memberId") Long memberId, @Param("productId") Long productId);

    CartItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CartItem record, @Param("example") CartItemExample example);

    int updateByExample(@Param("record") CartItem record, @Param("example") CartItemExample example);

    int updateByPrimaryKeySelective(CartItem record);

    int updateByPrimaryKey(CartItem record);

    int updateSelectAll(@Param("userId") Long userId, @Param("checked") Boolean checked);

    int updateByUserIdAndProductIdSelective(CartItem record);
}