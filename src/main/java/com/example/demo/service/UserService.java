package com.example.demo.service;

import com.example.demo.entity.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户信息
     * @return
     */
    List<UserInfo> getAllUserInfo();

    /**
     * 获取指定用户信息
     * @param userName 用户名
     * @return
     */
    UserInfo getUserInfo(String userName);

    /**
     * 添加一个用户
     * @param userInfo 用户信息
     * @return
     */
    boolean addUserInfo(UserInfo userInfo);

    /**
     * 修改一个用户信息
     * @param userInfo 用户信息
     * @return
     */
    boolean updateUserInfo(UserInfo userInfo);

    /**
     * 删除一个用户信息
     * @param userName 用户名
     * @return
     */
    boolean deleteUserInfo(String userName);
}
