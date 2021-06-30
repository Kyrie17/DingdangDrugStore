package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.controller.viewobject.OrderVo;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.mbg.model.CartItem;
import com.dingdang.DingdangDrugstore.mbg.model.Count;
import com.dingdang.DingdangDrugstore.mbg.model.Order;
import com.dingdang.DingdangDrugstore.mbg.model.OrderItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {

    /**
     * 创建订单，返回处方药品进行下一步操作
     */
    Long addOrder(Long userId, Long addressId) throws BusinessException;

    /**
     * 获取订单列表
     */
    PageInfo<Order> getOrderByCondition(String orderSn, int pageNum, int pageSize);

    /**
     * 通过订单id获取订单
     */
    Order getOrderById(Long orderId);

    /**
     * 通过用户id获取订单
     */
    PageInfo<OrderVo> getOrderByUserId(Long userId, Integer pageNum, Integer pageSize);

    /**
     * 获取订单商品
     */
    List<OrderItem> getOrderItem(Long orderId);

    /**
     * 统计每个月份的订单数和销售额
     * @return
     */
    List<Count> count();
}
