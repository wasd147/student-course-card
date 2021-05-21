package com.example.jingtao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPlus {
    private String postId;
    private String openid;
    private String school;
    private String content;
    private Date time;
    private ArrayList<String> arraylist;




}
