package com.example.jingtao.service;

import com.example.jingtao.entity.User;
import com.example.jingtao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int addAUser(User user) {
        int i = userMapper.insert(user);
        return i;
    }

    public int updateUser(User user) {
        int i = userMapper.updateByPrimaryKey(user);
        return i;
    }

    public User getUser(String openid) {
        User user = userMapper.selectByPrimaryKey(openid);
        return user;
    }

    public List<User> selectByBanji(String school, String college, String major, int grade, String banji) {
        List<User> users = userMapper.selectByBanji(school, college, major, grade, banji);
        return users;
    }

    public List<User> selectByGrade(String school, String college, String major, int grade) {
        List<User> users = userMapper.selectByGrade(school, college, major, grade);
        return users;
    }
}
