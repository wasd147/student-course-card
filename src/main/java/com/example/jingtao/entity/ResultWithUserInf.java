package com.example.jingtao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResultWithUserInf {
    private Object data;
    private UserInf userInf;
    private String time;

    public ResultWithUserInf(Object data, UserInf userInf) {
        if (data.getClass().equals(PostPlus.class)) {
            PostPlus postPlus = (PostPlus) data;
            this.data = data;
            this.userInf = userInf;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.time = format.format(postPlus.getTime());
        }
        if (data.getClass().equals(SchoolNewsPlus.class)) {
            SchoolNewsPlus newsPlus = (SchoolNewsPlus) data;
            this.data = data;
            this.userInf = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            this.time = format.format(newsPlus.getTime());
        }

    }
}
