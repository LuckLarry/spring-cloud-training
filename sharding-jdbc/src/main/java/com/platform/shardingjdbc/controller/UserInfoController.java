package com.platform.shardingjdbc.controller;

import com.platform.shardingjdbc.domain.UserInfo;
import com.platform.shardingjdbc.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping("/userinfo")
    public List<UserInfo> getUserInfos(){
        return userInfoRepository.findAll();
    }

    @GetMapping("/userinfo/{name}")
    public UserInfo addUserInfo(@PathVariable String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        return userInfoRepository.save(userInfo);
    }

    @GetMapping("/userinfo/wr/{name}")
    public UserInfo writeAndRead(@PathVariable String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfoRepository.saveAndFlush(userInfo);
//        return userInfoRepository.findById(userInfo.getId());
        return null;
    }

}
