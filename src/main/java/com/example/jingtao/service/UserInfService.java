package com.example.jingtao.service;

import com.example.jingtao.entity.UserInf;
import com.example.jingtao.mapper.UserInfMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfService {
    @Autowired
    private UserInfMapper userInfMapper;

    public int addAUserInf(UserInf userInf) {
        int insert = userInfMapper.insert(userInf);
        return insert;
    }

    public int updateUserInf(UserInf userInf) {
        int i = userInfMapper.updateByPrimaryKeySelective(userInf);
        return i;
    }

    public UserInf selectByOpenid(UserInf userInf) {

        UserInf userInf1 = userInfMapper.selectByPrimaryKey(userInf.getOpenid());
        return userInf1;
    }
}
