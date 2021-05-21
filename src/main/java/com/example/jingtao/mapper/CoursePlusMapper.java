package com.example.jingtao.mapper;

import com.example.jingtao.entity.CoursePlus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoursePlusMapper {
    int addCourse(CoursePlus coursePlus);

    int deleteACourse(CoursePlus coursePlus);

    int deleteAllCourseByOpenid(String openid);

    List<CoursePlus> selectByOpenidAndWeeks(String openid, String week);



}
