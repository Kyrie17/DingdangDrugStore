package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.common.Constant;
import com.dingdang.DingdangDrugstore.controller.viewobject.CommentVo;
import com.dingdang.DingdangDrugstore.controller.viewobject.OrderVo;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.mapper.*;
import com.dingdang.DingdangDrugstore.mbg.model.*;
import com.dingdang.DingdangDrugstore.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/3/2 14:51
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    CartItemMapper cartItemMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    AddressMapper addressMapper;

    @Override
    @Transactional
    public Long addOrder(Long userId, Long addressId) throws BusinessException {
        String orderSn = getOrderSn(); // 订单号
        Long orderId = initializeOrder(userId, orderSn); // 初始化订单

        BigDecimal totalAmount = new BigDecimal("0"); // 订单金额
        List<CartItem> cartItemList =  cartItemMapper.getCheckedItemByUserId(userId);

        // 计算订单金额，并将购物车中商品移除
        totalAmount = moveProductFromCartToOrder(cartItemList, totalAmount, orderId, orderSn);

        // 运费
        BigDecimal freightAmount = totalAmount.compareTo(BigDecimal.valueOf(Constant.FREE_FREIGHT)) > 0
                ? BigDecimal.valueOf(0) : BigDecimal.valueOf(Constant.FREIGHT_PRICE);

        // 实付金额
        BigDecimal payAmount = totalAmount.add(freightAmount);

        // 获取收货信息
        Address address = addressMapper.selectByPrimaryKey(addressId);

        // 插入订单
        Order order = new Order();
        order.setId(orderId);
        order.setTotalAmount(totalAmount);
        order.setFreightAmount(freightAmount);
        order.setPayAmount(payAmount);
        order.setReceiverName(address.getName());
        order.setReceiverPhone(address.getPhone());
        order.setReceiverDetailAddress(address.getAddress());
        orderMapper.updateByPrimaryKeySelective(order);
        return orderId;
    }

    @Override
    public List<Count> count() {
        return orderMapper.count();
    }

    // 获取订单编号
    public String getOrderSn() {
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        // 获取四位随机数
        Random random = new Random();
        int ranNum = (int)(random.nextDouble() * (9999 - 1000 + 1)) + 1000;
        String orderSn = "SD" + dateStr + ranNum;
        return orderSn;
    }

    /**
     * 初始化订单，并返回订单id
     */
    public Long initializeOrder(Long userId, String orderSn) {
        Order order = new Order();
        Date createTime = new Date();  // 创建订单时间
        Integer status = 0; // 订单状态
        order.setOrderSn(orderSn);
        order.setMemberId(userId);
        order.setCreateTime(createTime);
        order.setStatus(status);
        orderMapper.insertSelective(order);
        return order.getId();
    }

    @Override
    public PageInfo<Order> getOrderByCondition(String orderSn, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.selectOrderByCondition(orderSn);
        PageInfo<Order> pageInfo = new PageInfo<Order>(orderList);
        return pageInfo;
    }

    @Override
    public List<OrderItem> getOrderItem(Long orderId) {
        return orderItemMapper.selectByOrderId(orderId);
    }

    @Override
    public PageInfo<OrderVo> getOrderByUserId(Long userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.selectOrderByUserId(userId);
        //通过构造PageInfo对象获取分页信息，如当前页码，总页数，总条数
        List<OrderVo> orderVoList = convertToOrderVo(orderList);
        PageInfo<OrderVo> pageInfo = new PageInfo<OrderVo>(orderVoList);
        return pageInfo;
    }


    @Override
    public Order getOrderById(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    /**
     * 计算订单金额
     * 将购物车中商品移动到订单商品中
     */
    public BigDecimal moveProductFromCartToOrder(List<CartItem> cartItemList, BigDecimal totalAmount, Long orderId, String orderSn) {
        for (CartItem cartItem : cartItemList) {
            Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
            BigDecimal simplePrice = product.getPrice(); // 商品目前的单价
            BigDecimal price = simplePrice.multiply(BigDecimal.valueOf(cartItem.getQuantity())); // 单价 * 数量
            totalAmount = totalAmount.add(price); // 总价
            cartItemMapper.deleteByPrimaryKey(cartItem.getId()); // 删除购物车中该商品

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setOrderSn(orderSn);
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setProductPic(cartItem.getProductPic());
            orderItem.setProductName(cartItem.getProductName());
            orderItem.setProductBrand(cartItem.getProductBrand());
            orderItem.setProductPrice(cartItem.getPrice());
            orderItem.setProductQuantity(cartItem.getQuantity());
            orderItem.setRealAmount(price);
            orderItemMapper.insertSelective(orderItem);
        }
        return totalAmount;
    }

    /**
     * 将Comment转换为CommentVO
     */
    private List<OrderVo> convertToOrderVo(List<Order> orderList) {
        List<OrderVo> orderVoList = new ArrayList<>();
        for (Order order: orderList) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            OrderVo orderVo = new OrderVo();
            orderVo.setId(order.getId());
            orderVo.setOrderSn(order.getOrderSn());
            orderVo.setMemberId(order.getMemberId());
            orderVo.setMemberUsername(order.getMemberUsername());
            orderVo.setCreateTime(sdf.format(order.getCreateTime()));
            orderVo.setTotalAmount(order.getTotalAmount());
            orderVo.setFreightAmount(order.getFreightAmount());
            orderVo.setIntegrationAmount(order.getIntegrationAmount());
            orderVo.setPayAmount(order.getPayAmount());
            orderVo.setStatus(order.getStatus());
            orderVo.setDeliverySn(order.getDeliverySn());
            orderVo.setIntegration(order.getIntegration());
            orderVo.setReceiverName(order.getReceiverName());
            orderVo.setReceiverPhone(order.getReceiverPhone());
            orderVo.setReceiverProvince(order.getReceiverProvince());
            orderVo.setReceiverCity(order.getReceiverCity());
            orderVo.setReceiverRegion(order.getReceiverRegion());
            orderVo.setReceiverDetailAddress(order.getReceiverDetailAddress());
            orderVo.setConfirmStatus(order.getConfirmStatus());
//            orderVo.setPaymentTime(sdf.format(order.getPaymentTime()));
//            orderVo.setDeliverySn(sdf.format(order.getDeliveryTime()));
//            orderVo.setReceiveTime(sdf.format(order.getReceiveTime()));
            orderVoList.add(orderVo);
        }
        return orderVoList;
    }
}
