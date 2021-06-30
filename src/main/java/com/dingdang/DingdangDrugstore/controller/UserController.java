package com.dingdang.DingdangDrugstore.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.dingdang.DingdangDrugstore.common.Constant;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;
import com.dingdang.DingdangDrugstore.mbg.model.Member;
import com.dingdang.DingdangDrugstore.response.CommonReturnType;
import com.dingdang.DingdangDrugstore.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/2/21 14:49
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录接口
     */
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType login(@RequestParam(name="phone")String phone,
                                     @RequestParam(name="password")String password,
                                     HttpServletRequest request) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户名、手机号或密码不能为空");
        }
        //用户登陆服务,用来校验用户登陆是否合法
        Member member = userService.validateLogin(phone,this.EncodeByMd5(password));
        String token = getToken(member);
        return CommonReturnType.create(token);
    }

    public String getToken(Member user) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    /**
     * 获取所有的用户
     */
    @RequestMapping(value = "/get_user_id",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getUserId(@RequestParam(value = "token") String token) throws BusinessException {
        if (token == null || StringUtils.isEmpty(token)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 获取 token 中的 user id
        Long userId;
        try {
            userId = Long.valueOf(JWT.decode(token).getAudience().get(0));
        } catch (JWTDecodeException j) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        return CommonReturnType.create(userId);
    }

    /**
     * 用户注册接口
     * ,consumes={CONTENT_TYPE_FORMED}
     */
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType register(@RequestParam(name="username")String username,
                                     @RequestParam(name="phone")String phone,
                                     @RequestParam(name="password")String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户名、手机号或密码不能为空");
        }
        Member member = new Member();
        member.setUsername(username);
        member.setPhone(phone);
        member.setPassword(EncodeByMd5(password));
        userService.register(member);
        return CommonReturnType.create(null);
    }

    public String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    /**
     * 获取所有的用户
     */
    @RequestMapping(value = "/get_user",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(value = "username", required = false) String username,
                                    @RequestParam(value = "phone", required = false) String phone,
                                    @RequestParam("pageNum") Integer pageNum) throws BusinessException {
        if (pageNum == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "页码不能为空");
        }
        Integer pageSize = Constant.PAGESIZE;
        PageInfo<Member> pageInfo = userService.getUserByCondition(username, phone, pageNum, pageSize);
        return CommonReturnType.create(pageInfo);
    }

    /**
     * 根据id获取用户信息
     */
    @RequestMapping(value = "/get_user_by_id",method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getUserById(@RequestParam(value = "userId") Long userId) throws BusinessException {
        if (userId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户id不能为空");
        }
        Member member = userService.getUserById(userId);
        return CommonReturnType.create(member);
    }

    /**
     * 修改用户状态
     */
    @RequestMapping(value = "/update_user_status",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateUserStatus(@RequestParam(name="userId")Long userId,
                                     @RequestParam(name="userStatus")Boolean userStatus) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (userId == null || userStatus == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Member member = new Member();
        member.setId(userId);
        member.setStatus(userStatus);
        userService.updateStatusByUserId(member);
        return CommonReturnType.create(null);
    }
    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/update_user",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType updateUser(@RequestBody Member member) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (member == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        userService.updateUser(member);
        return CommonReturnType.create(null);
    }


    /**
     * 删除用户
     */
    @RequestMapping(value = "/delete_user_by_id",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deleteUserById(@RequestParam(name="userId")Long userId) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        if (userId == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        userService.deleteUserById(userId);
        return CommonReturnType.create(null);
    }
}
