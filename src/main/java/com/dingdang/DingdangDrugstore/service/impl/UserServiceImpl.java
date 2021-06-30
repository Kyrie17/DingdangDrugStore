package com.dingdang.DingdangDrugstore.service.impl;

import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.mapper.MemberMapper;
import com.dingdang.DingdangDrugstore.mbg.model.Member;
import com.dingdang.DingdangDrugstore.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/2/21 14:53
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void deleteUserById(Long userId) {
        memberMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public Member getUserById(Long id) {
        Member member = memberMapper.selectByPrimaryKey(id);
        return member;
    }

    @Override
    public void updateUser(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public PageInfo<Member> getUserByCondition(String username, String phone, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Member> memberList = memberMapper.selectUserByCondition(username, phone);
        //通过构造PageInfo对象获取分页信息，如当前页码，总页数，总条数
        PageInfo<Member> pageInfo = new PageInfo<Member>(memberList);
        return pageInfo;
    }

    @Override
    public Member validateLogin(String phone, String encrptPassword) throws BusinessException {
        Member member = memberMapper.selectByPhone(phone);

        if(member == null){
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }
        //比对用户信息内加密的密码是否和传输进来的密码相匹配
        if(!StringUtils.equals(encrptPassword, member.getPassword())){
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }

        return member;
    }

    @Override
    public void register(Member member) throws BusinessException{

        member.setStatus(true); // 启用账号
        member.setCreateTime(new Date()); // 创建日期
        member.setIntegration(0); // 现存积分
        member.setHistoryIntegration(0); // 历史积分
        try{
            memberMapper.insertSelective(member);
        }catch(DuplicateKeyException ex){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"手机号已重复注册");
        }
    }

    @Override
    public void updateStatusByUserId(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }
}
