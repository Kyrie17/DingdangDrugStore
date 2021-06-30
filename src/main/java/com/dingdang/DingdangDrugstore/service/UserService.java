package com.dingdang.DingdangDrugstore.service;

import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.mbg.model.Member;
import com.github.pagehelper.PageInfo;

public interface UserService {

    // 通过用户id获取用户对象
    Member getUserById(Long id);

    // 注册
    void register(Member member) throws BusinessException;

    // 登录
    Member validateLogin(String phone, String encrptPassword) throws BusinessException;

    // 通过用户名、手机号获取用户列表
    PageInfo<Member> getUserByCondition(String username, String phone, int pageNum, int pageSize);

    // 修改用户状态
    void updateStatusByUserId(Member member);

    // 修改用户信息
    void updateUser(Member member);

    // 删除用户
    void deleteUserById(Long userId);
}
