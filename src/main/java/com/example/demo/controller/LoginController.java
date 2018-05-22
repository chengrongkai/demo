package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    private Map<String,Object> login(@RequestBody UserInfo userInfo){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean success = loginService.login(userInfo);
        map.put("success",success);
        return map;
    }
    @PostMapping(value = "/register")
    private Map<String,Object> register(@RequestBody UserInfo userInfo){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean success = loginService.register(userInfo);
        map.put("success",success);
        return map;
    }
    @PostMapping(value = "/resetPassword")
    private Map<String,Object> resetPassword(@RequestBody UserInfo userInfo){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean success = loginService.resetPassword(userInfo);
        map.put("success",success);
        return map;
    }

}
