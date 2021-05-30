package com.example.jingtao.service;

import com.example.jingtao.entity.SchoolNews;
import com.example.jingtao.entity.SchoolNewsPlus;
import com.example.jingtao.mapper.SchoolNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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

    public List<SchoolNewsPlus> getFirstPageSchoolNews(int page, int num) {
        page = 1;
        List<SchoolNews> order = schoolNewsMapper.getAllSchoolNews();
        int b_index = (page - 1) * num;
        int e_index = page * num - 1;
        List<SchoolNews> res_post = null;
        if (b_index >= order.size()) {
            res_post = null;
        } else {
            if (e_index < order.size()) {
                res_post = order.subList(b_index, e_index + 1);
            } else {
                res_post = order.subList(b_index, order.size());
            }
        }
        List<SchoolNewsPlus> list = new ArrayList<>();
        if (res_post != null) {
            for (SchoolNews schoolNews : res_post) {
                list.add(schoolNews.toSchoolNewsPlus());

            }
        }
        return list;
    }

    public List<SchoolNewsPlus> getPageSchoolNews(int page, int num, Date time) {
        List<SchoolNews> order = schoolNewsMapper.getAllSchoolNews();
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getTime().after(time)) {
                order.remove(i);
            }
        }
        int b_index = (page - 1) * num;
        int e_index = page * num - 1;
        List<SchoolNews> res_post = null;
        if (b_index >= order.size()) {
            res_post = null;
        } else {
            if (e_index < order.size()) {
                res_post = order.subList(b_index, e_index + 1);
            } else {
                res_post = order.subList(b_index, order.size());
            }
        }
        List<SchoolNewsPlus> list = new ArrayList<>();
        if (res_post != null) {
            for (SchoolNews schoolNews : res_post) {
                list.add(schoolNews.toSchoolNewsPlus());

            }
        }
        return list;
    }
}
