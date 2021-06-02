package com.example.jingtao.entity;

import com.example.jingtao.utils.BeanUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contacter {
    private String openid;
    private String nickname;
    private String headImg;
    private int note;

    public Contacter(String openid, int note) {
        UserInf userInf = BeanUtils.userInfService.selectByOpenid(new UserInf(openid, null, null));
        this.openid = openid;
        this.nickname = userInf.getNickname();
        this.headImg = userInf.getHeadImg();
        this.note = note;

    }
}
