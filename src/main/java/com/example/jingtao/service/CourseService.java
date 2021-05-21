package com.example.jingtao.service;

import com.example.jingtao.autoimport.AutoImport;
import com.example.jingtao.entity.Course;
import com.example.jingtao.entity.CoursePlus;
import com.example.jingtao.mapper.CoursePlusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class CourseService {
    @Autowired
    private CoursePlusMapper coursePlusMapper;

    public void importCourseByOpenidAndStudentId(String openid, String username, String password) {
        //调用方法得到course属性集合
        List<Map<String, String>> list_course = AutoImport.fun(username, password);
        for (Map<String, String> map : list_course) {
            addCourse(new Course(openid, map));
        }

    }

    public int addCourse(Course course) {
        int i = coursePlusMapper.addCourse(course.toCoursePlus());
        return i;

    }

    public int deleteACourse(Course course) {
        int i = coursePlusMapper.deleteACourse(course.toCoursePlus());
        return i;

    }

    public int deleteAllCourseByOpenid(String openid) {
        int i = coursePlusMapper.deleteAllCourseByOpenid(openid);
        return i;

    }

    public List<Course> selectByOpenidAndWeeks(String openid, String week) {
        List<CoursePlus> coursePluses = coursePlusMapper.selectByOpenidAndWeeks(openid, week);
        for (int i = 0; i < coursePluses.size(); i++) {
            String[] split = coursePluses.get(i).getWeeks().split("_");
            List<String> strings = Arrays.asList(split);
            if (!strings.contains(week)) {
                coursePluses.remove(i);
            }

        }
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < coursePluses.size(); i++) {
            courses.add(coursePluses.get(i).toCourse());
        }
        return courses;
    }

    public Course selectByOpenidAndTime(String openid, String week, int day, int jishu) {
        List<Course> courses = selectByOpenidAndWeeks(openid, week);
        //本周课表
        for (Course course : courses) {
            if (course.getDay() == day && course.getJieshu() == jishu) {
                return course;
            }
        }
        return null;

    }
}
