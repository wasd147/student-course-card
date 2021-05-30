package com.example.jingtao.utils;

import com.example.jingtao.service.UserInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils {
    public static UserInfService userInfService;

    @Autowired
    public void setUserInfService(UserInfService userInfService) {
        this.userInfService = userInfService;
    }
}
