package com.example.demo.service;

import com.example.demo.entity.UserInfo;

import java.util.List;

public interface LoginService {
    boolean login(UserInfo userInfo);
    boolean register(UserInfo userInfo);
    boolean resetPassword(UserInfo userInfo);
    UserInfo getUserInfo(String userName);
}
