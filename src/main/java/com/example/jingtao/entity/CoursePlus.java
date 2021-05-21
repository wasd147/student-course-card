package com.example.jingtao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePlus {
    private String openid;
    private String courseName;
    private String classroom;
    private String weeks;
    private int day;
    private int jieshu;
    private String teacher;

    public Course toCourse() {
        String[] s = weeks.split("_");
        int[] temp = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            temp[i] = Integer.parseInt(s[i]);

        }
        return new Course(openid, courseName, classroom, temp,day, jieshu, teacher);

    }
}
