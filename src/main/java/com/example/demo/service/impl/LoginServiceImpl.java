package com.example.demo.service.impl;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 登录系统
     * @param userInfo
     * @return
     */
    @Override
    public boolean login(UserInfo userInfo) {
        if (userInfo.getUserName()==null){
            return false;
        }
        UserInfo userInfo1 = userInfoDao.queryUserInfoByUserName(userInfo.getUserName());
        if (null == userInfo1){
            return false;
        }
        if (userInfo1.getUserId() == null){
            return false;
        }
        if (userInfo.getUserName().equals(userInfo1.getUserName())){
            return true;
        }
        return false;
    }

    
    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    @Override
    public boolean register(UserInfo userInfo) {
        if (userInfo.getUserName()==null){
            return false;
        }
        UserInfo userInfo1 = userInfoDao.queryUserInfoByUserName(userInfo.getUserName());
        if (null != userInfo1){
            return false;
        }
        userInfo.setCreateTime(new Date());
        int effectNum = userInfoDao.addUserInfo(userInfo);
        if (effectNum>0){
            return true;
        }
        return false;
    }

    /**
     * 重置密码
     * @param userInfo
     * @return
     */
    @Override
    public boolean resetPassword(UserInfo userInfo) {
        if (userInfo.getUserName()==null){
            return false;
        }
        UserInfo userInfo1 = userInfoDao.queryUserInfoByUserName(userInfo.getUserName());
        if (null == userInfo1){
            return false;
        }
        if (userInfo1.getUserId() == null){
            return false;
        }
        userInfo.setUpdateTime(new Date());
        userInfo.setPassword(userInfo.getPhone().substring(6));
        int effectNum = userInfoDao.updateUserInfoByUserName(userInfo);
        if (effectNum>0){
            return true;
        }
        return false;
    }

    /**
     * 获取用户信息
     * @param userName 用户名
     * @return
     */
    @Override
    public UserInfo getUserInfo(String userName) {
        UserInfo userInfo = userInfoDao.queryUserInfoByUserName(userName);
        return userInfo;
    }
}
