package com.example.jingtao.service;

import com.example.jingtao.entity.SchoolNews;
import com.example.jingtao.entity.SchoolNewsPlus;
import com.example.jingtao.mapper.SchoolNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SchoolNewsService {
    @Autowired
    private SchoolNewsMapper schoolNewsMapper;

    public int addASchoolNews(SchoolNews schoolNews) {
        int i = schoolNewsMapper.insert(schoolNews);
        return i;
    }

    public int deleteSchoolNewsByTitle(String title) {
        int i = schoolNewsMapper.deleteByPrimaryKey(title);
        return i;
    }

    public List<SchoolNewsPlus> getAllSchoolNews() {
       // System.out.println("执行到getallnews方法");
        List<SchoolNews> allSchoolNews = schoolNewsMapper.getAllSchoolNews();
       // System.out.println("ok");
        List<SchoolNewsPlus> list = new ArrayList<>();
        for (SchoolNews SchoolNew : allSchoolNews) {
            list.add(SchoolNew.toSchoolNewsPlus());
        }
        return list;
    }
}
