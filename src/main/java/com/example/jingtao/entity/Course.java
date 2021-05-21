package com.example.jingtao.entity;

import com.example.jingtao.autoimport.wasd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String openid;
    private String courseName;
    private String classroom;
    private int[] weeks;
    private int day;
    private int jieshu;
    private String teacher;

    public Course(String openid, Map<String, String> map) {
        this.openid = openid;
        this.courseName = map.get("courseName");
        this.classroom = map.get("classroom");
        this.weeks = wasd.parseWeeks(map.get("weeks"));
        this.day = Integer.parseInt(map.get("day"));
        this.jieshu = Integer.parseInt(map.get("jieshu"));
        this.teacher = map.get("teacher");
    }

    public CoursePlus toCoursePlus() {
        String temp = "";
        for (int i = 0; i < weeks.length; i++) {
            temp += weeks[i];
            if (i != (weeks.length - 1)) {
                temp += "_";
            }
        }
        return new CoursePlus(openid, courseName, classroom, temp, day, jieshu, teacher);
    }
}
