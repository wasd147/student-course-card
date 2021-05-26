package com.example.jingtao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPlus {
    private String openid;
    private String school;
    private String college;
    private String major;
    private Integer grade;
    private String banji;
    private String nickname;
    private String headImg;

}
