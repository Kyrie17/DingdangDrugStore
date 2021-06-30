package com.dingdang.DingdangDrugstore.controller;

import com.dingdang.DingdangDrugstore.common.Constant;
import com.dingdang.DingdangDrugstore.controller.viewobject.OrderVo;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.Count;
import com.dingdang.DingdangDrugstore.mbg.model.Order;
import com.dingdang.DingdangDrugstore.mbg.model.OrderItem;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/1 23:54
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 创建订单
     */
    @RequestMapping(value = "/add_order",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addOrder(@RequestParam(value = "userId") Long userId,
                                     @RequestParam(value = "addressId") Long addressId) throws BusinessException {
        if (userId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "请登录");
        }
        Long orderId = orderService.addOrder(userId, addressId);
        return CommonReturnType.create(orderId);
    }

    /**
     * 获取订单
     */
    @RequestMapping(value = "/get_order",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getOrder(@RequestParam(value = "orderSn", required = false) String orderSn,
                                     @RequestParam("pageNum") Integer pageNum) throws BusinessException {
        if (pageNum == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "页码不能为空");
        }
        Integer pageSize = Constant.PAGESIZE;
        PageInfo<Order> pageInfo = orderService.getOrderByCondition(orderSn, pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }

    /**
     * 获取订单
     */
    @RequestMapping(value = "/get_order_by_id",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getOrder(@RequestParam(value = "orderId") Long orderId) throws BusinessException {
        if (orderId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Order order = orderService.getOrderById(orderId);
        return CommonReturnType.create(order);
    }

    /**
     * 获取订单
     */
    @RequestMapping(value = "/get_order_by_userid",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getOrder(@RequestParam(value = "userId") Long userId,
                                     @RequestParam("pageNum") Integer pageNum) throws BusinessException {
        if (pageNum == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "页码不能为空");
        }
        Integer pageSize = Constant.PAGESIZE;
        PageInfo<OrderVo> pageInfo = orderService.getOrderByUserId(userId, pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }

    /**
     * 获取订单
     */
    @RequestMapping(value = "/get_order_item",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getOrderItem(@RequestParam(value = "orderId") Long orderId) throws BusinessException {
        if (orderId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "页码不能为空");
        }
        List<OrderItem> orderItemList = orderService.getOrderItem(orderId);
        return CommonReturnType.create(orderItemList);
    }

    /**
     * 获取统计数据
     */
    @RequestMapping(value = "/count",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType count() throws BusinessException {
        List<Count> countList = orderService.count();
        return CommonReturnType.create(countList);
    }
}
