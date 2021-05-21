package com.example.jingtao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolNewsPlus {
    private String title;
    private String content;
    private String img_src;
    private Date time;

}
